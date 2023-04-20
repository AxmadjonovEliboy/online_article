package uz.boom.core_project_jwt.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Result;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sun 10:50. 16/04/23
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Long>, BaseRepository {

    Optional<Result> findByQuizId(Long quizId);

    Optional<List<Result>> findAllByAuthUserId(Long id);

}
