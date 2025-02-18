package Spring_Security_JWT.modules.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {

    List<Account> findAllByOrderByCreatedDateDesc();

    Optional<Account> findById(String id);

    Optional<Account> findByPhone(String Phone);

    Optional<Account> findByEmail(String email);

    boolean existsById(String id);

    Boolean existsByEmail(String email);

    Boolean existsByFullname(String fullname);

    Boolean existsByPhone(String phone);

    Account findByIdAndPassword(String id, String password);

}
