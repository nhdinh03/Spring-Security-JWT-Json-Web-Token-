package Spring_Security_JWT.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Security_JWT.auth.models.SecurityERole;
import Spring_Security_JWT.auth.models.SecurityRole;

;

public interface RoleRepository extends JpaRepository<SecurityRole, Long> {
    Optional<SecurityRole> findByName(SecurityERole name);

}