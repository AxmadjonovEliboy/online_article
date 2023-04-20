package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleTypeDTO;
import uz.boom.core_project_jwt.entity.Article;
import uz.boom.core_project_jwt.entity.ArticleTitle;
import uz.boom.core_project_jwt.entity.ArticleType;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.ArticleTypeMapper;
import uz.boom.core_project_jwt.repository.ArticleRepository;
import uz.boom.core_project_jwt.repository.ArticleTitleRepository;
import uz.boom.core_project_jwt.repository.ArticleTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.ArticleTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Mon 16:28. 17/04/23
 */
@Service
public class ArticleTypeServiceImpl extends AbstractService<ArticleTypeRepository, ArticleTypeMapper> implements ArticleTypeService {

    private final ArticleTitleRepository articleTitleRepository;

    private final ArticleRepository articleRepository;

    public ArticleTypeServiceImpl(ArticleTypeRepository repository, ArticleTypeMapper mapper, ArticleTitleRepository articleTitleRepository, ArticleRepository articleRepository) {
        super(repository, mapper);
        this.articleTitleRepository = articleTitleRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public Long create(ArticleTypeCreateDTO dto) {
        ArticleType articleType = mapper.fromCreateDTO(dto);
        ArticleType savedArticleType = repository.save(articleType);
        return savedArticleType.getId();
    }

    @Override
    public List<ArticleTypeDTO> getAll() {
        List<ArticleType> articleTypes = repository.findAll();
        return mapper.toDTO(articleTypes);
    }

    @Override
    public ArticleTypeDTO get(Long id) {
        ArticleType articleType = repository.findById(id).orElseThrow(() -> new NotFoundException("ARTICLE TYPE NOT FOUND!"));
        return mapper.toDTO(articleType);
    }

    @Override
    public Long update(ArticleTypeDTO dto) {
        ArticleType saveArticleType = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
        ArticleType articleType = mapper.fromUpdateDTO(dto, saveArticleType);
        ArticleType save = repository.save(articleType);
        return save.getId();
    }

    @Override
    public Long delete(Long id) {
        Optional<ArticleType> articleType = repository.findById(id);
        if (articleType.isPresent()) {
            List<ArticleTitle> savedArticleTitle = articleTitleRepository.findAllByArticleTypeId(id).orElseThrow(() -> new NotFoundException("NOT FOUND"));
            savedArticleTitle.forEach(articleTitle -> {
                articleTitle.setDeleted(Boolean.TRUE);
                articleTitleRepository.save(articleTitle);
                Article article = articleRepository.findByArticleTitleId(articleTitle.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND"));
                article.setDeleted(Boolean.TRUE);
                articleRepository.save(article);
            });
        }
        ArticleType savedArticleType = articleType.orElseThrow();
        savedArticleType.setDeleted(Boolean.TRUE);
        ArticleType save = repository.save(savedArticleType);
        return save.getId();
    }
}
