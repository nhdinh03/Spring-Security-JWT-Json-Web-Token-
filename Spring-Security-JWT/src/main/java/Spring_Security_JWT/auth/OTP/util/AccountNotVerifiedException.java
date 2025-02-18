package Spring_Security_JWT.auth.OTP.util;


public class AccountNotVerifiedException extends RuntimeException {
    public AccountNotVerifiedException(String message) {
        super(message);
    }
}
