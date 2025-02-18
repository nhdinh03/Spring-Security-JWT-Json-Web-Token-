package Spring_Security_JWT.auth.payload.request;


import lombok.Data;

@Data
public class ForgotPassword {
    String code;
    String newPassword;
}
