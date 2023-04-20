package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.GlossaryType;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

/**
 * @author Jarvis on Tue 20:56. 18/04/23
 */
@Repository
public interface GlossaryTypeRepository extends JpaRepository<GlossaryType, Long>, BaseRepository {

}
