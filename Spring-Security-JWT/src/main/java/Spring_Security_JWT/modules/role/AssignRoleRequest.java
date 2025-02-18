package Spring_Security_JWT.modules.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignRoleRequest {
    private String accountId;
    private Long roleId;

}
