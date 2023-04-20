package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.QuizType;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

/**
 * @author Jarvis on Tue 23:45. 18/04/23
 */
@Repository
public interface QuizTypeRepository extends JpaRepository<QuizType, Long>, BaseRepository {
}
