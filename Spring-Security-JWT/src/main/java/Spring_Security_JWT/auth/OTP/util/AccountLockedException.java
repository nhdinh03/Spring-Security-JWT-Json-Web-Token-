package Spring_Security_JWT.auth.OTP.util;


public class AccountLockedException extends RuntimeException {
    public AccountLockedException(String message) {
        super(message);
    }
}