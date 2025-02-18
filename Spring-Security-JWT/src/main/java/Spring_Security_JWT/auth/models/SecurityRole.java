package Spring_Security_JWT.auth.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Spring_Security_JWT.modules.accountRole.AccountRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class SecurityRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SecurityERole name;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<AccountRole> accountRoles;

   
}
