package Spring_Security_JWT.auth.OTP.util;


public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}