package Spring_Security_JWT.modules.accountRole;


import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring_Security_JWT.modules.account.Account;



public interface AccountRoleDAO extends JpaRepository<AccountRole, AccountRolePK> {

        Optional<AccountRole> findByAccountAndRole(Account account, Role role);

}


