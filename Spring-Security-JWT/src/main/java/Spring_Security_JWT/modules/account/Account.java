package Spring_Security_JWT.modules.account;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import Spring_Security_JWT.auth.models.Gender;
import Spring_Security_JWT.auth.models.SecurityRole;
import Spring_Security_JWT.modules.accountRole.AccountRole;
import Spring_Security_JWT.modules.verification.Verifications;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @Column(length = 100, columnDefinition = "NVARCHAR(100)")
    private String id;

    @Column(unique = true, length = 15)
    private String phone;

    @Column(length = 100)
    private String fullname;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String address;

    @Column(nullable = false, unique = true, length = 350)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String image;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer status = 1;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private Date createdDate = new Date();

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Boolean verified = false;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int points = 0;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AccountRole> accountRoles;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Verifications> verifications;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Accounts_Roles", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<SecurityRole> roles = new HashSet<>();

    public Account(String id, String phone, String fullname, String email, String password) {
        this.id = id;
        this.phone = phone;
        this.fullname = fullname;
        this.email = email;
        this.password = password;

    }

}
