package Spring_Security_JWT.modules.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/role")
public class RoleAPI {

    @Autowired
    RoleDAO roleDAO;

    @GetMapping("/get/all")
    public ResponseEntity<List<Role>> findAll() {
        List<Role> roles = roleDAO.findAllByOrderByIdDesc();
        return ResponseEntity.ok(roles);
    }



}
