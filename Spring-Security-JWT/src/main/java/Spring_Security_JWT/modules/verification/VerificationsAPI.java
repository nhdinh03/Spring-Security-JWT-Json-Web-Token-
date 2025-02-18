package Spring_Security_JWT.modules.verification;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verifications")
public class VerificationsAPI {

    @Autowired
    VerificationsDAO verificationsDAO;

    @GetMapping("/get/all")
    public ResponseEntity<List<Verifications>> findAll() {
        List<Verifications> distinctives = verificationsDAO.findAll();
        return ResponseEntity.ok(distinctives);
    }

}
