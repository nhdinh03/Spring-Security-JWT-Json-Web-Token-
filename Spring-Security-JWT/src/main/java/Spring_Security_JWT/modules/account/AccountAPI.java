package Spring_Security_JWT.modules.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountAPI {

    @Autowired
    private AccountDAO accountDao;

    // ✅ Lấy tất cả tài khoản
    @GetMapping("/get/all")
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountDao.findAll();

        return ResponseEntity.ok(accounts);
    }

}
