package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Question;
import uz.boom.core_project_jwt.entity.QuizQuestion;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sun 01:56. 16/04/23
 */
@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long>, BaseRepository {

    @Query(value = "select q.* from online_article.quiz_question qq  \n" +
            " inner join online_article.question q  \n" +
            "                    on qq.question_id = q.id \n" +
            "where qq.quiz_id = :quizId ", nativeQuery = true)
    Optional<List<Question>> findByQuizId(@Param("quizId") Long quizId);

    Optional<QuizQuestion> findByQuizIdAndQuestionId(Long quizId, Long questionId);

}
