package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.article_title.*;
import uz.boom.core_project_jwt.entity.Article;
import uz.boom.core_project_jwt.entity.ArticleTitle;
import uz.boom.core_project_jwt.entity.ArticleType;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.ArticleMapper;
import uz.boom.core_project_jwt.mapper.ArticleTitleMapper;
import uz.boom.core_project_jwt.repository.ArticleRepository;
import uz.boom.core_project_jwt.repository.ArticleTitleRepository;
import uz.boom.core_project_jwt.repository.ArticleTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.ArticleTitleService;
import uz.boom.core_project_jwt.utils.SecurityUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author Jarvis on Sat 01:07. 15/04/23
 */
@Service
public class ArticleTitleServiceImpl extends AbstractService<ArticleTitleRepository, ArticleTitleMapper> implements ArticleTitleService {

    private final ArticleTypeRepository articleTypeRepository;
    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    public ArticleTitleServiceImpl(ArticleTitleRepository repository, ArticleTitleMapper mapper, ArticleTypeRepository articleTypeRepository, ArticleRepository articleRepository, ArticleMapper articleMapper) {
        super(repository, mapper);
        this.articleTypeRepository = articleTypeRepository;
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public Long create(ArticleTitleCreateDTO dto) {
        ArticleTitle articleTitle = mapper.fromCreateDTO(dto);
        articleTitle.setCreatedBy(SecurityUtils.getCurrentUserDetails().getId());
        ArticleType savedArticleType = articleTypeRepository.findById(dto.getArticleTypeId()).orElseThrow(() -> new NotFoundException("TYPE NOT FOUND"));
        articleTitle.setArticleType(savedArticleType);
        ArticleTitle savedArticleTitle = repository.save(articleTitle);
        Article article = articleMapper.fromCreateDTO(dto.getArticleCreateDTO());
        article.setCreatedBy(SecurityUtils.getCurrentUserDetails().getId());
        article.setArticleTitle(savedArticleTitle);
        articleRepository.save(article);
        return savedArticleTitle.getId();
    }

    @Override
    public List<ArticleTitleDTO> getAll(Long articleTypeId) {
        List<ArticleTitle> savedArticleTitles = repository.findAllByArticleTypeId(articleTypeId).orElseThrow(() -> new NotFoundException("NOT FOUND EXCEPTION"));
        return mapper.toDTO(savedArticleTitles);
    }

    @Override
    public ArticleTitleArticleDTO get(Long id) {
        ArticleTitle savedArticleTitle = repository.findById(id).orElseThrow(() -> new NotFoundException("ARTICLE TITLE NOT FOUND!"));
        ArticleTitleDTO articleTitleDTO = mapper.toDTO(savedArticleTitle);
        Article savedArticle = articleRepository.findByArticleTitleId(articleTitleDTO.getId()).orElseThrow(() -> new NotFoundException("ARTICLE NOT FOUND!"));
        ArticleDTO articleDTO = articleMapper.toDTO(savedArticle);
        return new ArticleTitleArticleDTO(articleTitleDTO, articleDTO);
    }

    @Override
    public Long update(ArticleTitleUpdateDTO dto) {
        ArticleTitle savedArticleTitle = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("ARTICLE TITLE NOT FOUND"));
        ArticleTitle articleTitle = mapper.fromUpdateDTO(dto, savedArticleTitle);
        if (Objects.nonNull(dto.getArticleContent())) {
            Article article = articleRepository.findByArticleTitleId(dto.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            article.setArticleContent(dto.getArticleContent());
            articleRepository.save(article);
        }
        ArticleTitle saveUser = repository.save(articleTitle);
        return saveUser.getId();
    }

    @Override
    public Long delete(Long id) {
        ArticleTitle savedArticleTitle = repository.findById(id).orElseThrow(() -> new NotFoundException("ARTICLE TITLE NOT FOUND!"));
        articleRepository.deleteArticleByArticleId(savedArticleTitle.getId());
        savedArticleTitle.setDeleted(Boolean.TRUE);
        ArticleTitle articleTitle = repository.save(savedArticleTitle);
        return articleTitle.getId();

    }
}
