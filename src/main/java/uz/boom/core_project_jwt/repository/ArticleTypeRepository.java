package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.ArticleType;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

/**
 * @author Jarvis on Mon 16:26. 17/04/23
 */
@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long>, BaseRepository {
}
