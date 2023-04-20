package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.ArticleTitle;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sat 01:04. 15/04/23
 */
@Repository
public interface ArticleTitleRepository extends JpaRepository<ArticleTitle, Long>, BaseRepository {


    Optional<List<ArticleTitle>> findAllByArticleTypeId(Long id);


}
