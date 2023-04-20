package uz.boom.core_project_jwt.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Article;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.Optional;

/**
 * @author Jarvis on Sat 01:05. 15/04/23
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, BaseRepository {

    Optional<Article> findByArticleTitleId(Long id);

    @Transactional
    @Modifying
    @Query(value = "update online_article.article a set deleted = true " +
            "where a.article_title_id = :article_id", nativeQuery = true)
    void deleteArticleByArticleId(@Param("article_id") Long id);

}
