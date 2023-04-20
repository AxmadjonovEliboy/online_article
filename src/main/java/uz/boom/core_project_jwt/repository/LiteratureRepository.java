package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Literature;
import uz.boom.core_project_jwt.enums.LiteratureType;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Tue 03:23. 18/04/23
 */
@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Long>, BaseRepository {


    Optional<List<Literature>> findAllByLiteratureType(LiteratureType type);
}
