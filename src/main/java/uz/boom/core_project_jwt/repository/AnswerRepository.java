package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Answer;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sat 16:53. 15/04/23
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>, BaseRepository {

    Optional<List<Answer>> findByQuestionId(Long id);


}
