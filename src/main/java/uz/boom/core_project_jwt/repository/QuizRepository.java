package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Quiz;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.Optional;

/**
 * @author Jarvis on Sun 01:08. 16/04/23
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>, BaseRepository {

    @Query(value = "select * from online_article.quiz q where q.quiz_type_id = :quizTypeId and q.created_by = :userId and q.is_closed = false", nativeQuery = true)
    Optional<Quiz> findByQuizTypeId(@Param("quizTypeId") Long quizTypeId, @Param("userId") Long userId);

}
