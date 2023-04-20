package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.article_title.ArticleCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleDTO;
import uz.boom.core_project_jwt.dto.article_title.ArticleUpdateDTO;
import uz.boom.core_project_jwt.entity.Article;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.ArticleMapper;
import uz.boom.core_project_jwt.repository.ArticleRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.ArticleService;

import java.util.List;

/**
 * @author Jarvis on Sat 01:10. 15/04/23
 */
@Service
public class ArticleServiceImpl extends AbstractService<ArticleRepository, ArticleMapper> implements ArticleService {
    public ArticleServiceImpl(ArticleRepository repository, ArticleMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(ArticleCreateDTO dto) {
        // TODO : I THINK THIS METHOD IS NOT USED
        return null;
    }

    @Override
    public List<ArticleDTO> getAll() {
        List<Article> savedArticles = repository.findAll();
        return mapper.toDTO(savedArticles);
    }

    @Override
    public ArticleDTO get(Long id) {
        Article article = repository.findById(id).orElseThrow(() -> new NotFoundException("ARTICLE NOT FOUND!"));
        return mapper.toDTO(article);
    }

    @Override
    public Long update(ArticleUpdateDTO dto) {
        Article article = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("ARTICLE NOT FOUND!"));
        Article updateArticle = mapper.fromUpdateDTO(dto, article);
        Article savedArticle = repository.save(updateArticle);
        return savedArticle.getId();
    }

    @Override
    public Long delete(Long id) {
        Article article = repository.findById(id).orElseThrow(() -> new NotFoundException("ARTICLE NOT FOUND!"));
        article.setDeleted(Boolean.TRUE);
        Article savedArticle = repository.save(article);
        return savedArticle.getId();
    }
}
