package uz.boom.core_project_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.boom.core_project_jwt.entity.AuthUser;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

import java.util.Optional;

/**
 * @author Jarvis on Sat 11:15. 08/04/23
 */
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    Optional<AuthUser> findByEmail(String email);
}
