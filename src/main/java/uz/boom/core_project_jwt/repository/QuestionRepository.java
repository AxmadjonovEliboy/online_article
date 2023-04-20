package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.dto.question.QuestionTitleAnswerDTO;
import uz.boom.core_project_jwt.entity.Question;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sat 16:52. 15/04/23
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, BaseRepository {

    @Query(value = "SELECT * FROM online_article.question q where q.quiz_type_id = :typeId ORDER BY random() LIMIT :count", nativeQuery = true)
    Optional<List<Question>> findAllBySize(@Param("count") Integer count ,@Param("typeId") Long typeId);


    @Query(value = "select  q.* from online_article.quiz_question qq  \n" +
            " inner join online_article.question q  \n" +
            "                    on qq.question_id = q.id\n" +
            "where qq.quiz_id = :quizId", nativeQuery = true)
    Optional<List<Question>> findAllByQuizId(@Param("quizId") Long quizId);


    Optional<List<Question>> findAllByQuizTypeId(Long id);
}
