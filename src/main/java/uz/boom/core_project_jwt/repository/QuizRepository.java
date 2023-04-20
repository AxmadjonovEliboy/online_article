package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Quiz;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

/**
 * @author Jarvis on Sun 01:08. 16/04/23
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>, BaseRepository {
}
