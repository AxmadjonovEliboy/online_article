package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.Glossary;
import uz.boom.core_project_jwt.entity.GlossaryType;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Tue 04:15. 18/04/23
 */
@Repository
public interface GlossaryRepository extends JpaRepository<Glossary, Long>, BaseRepository {

    Optional<List<Glossary>> findAllByGlossaryTypeId(Long id);

}
