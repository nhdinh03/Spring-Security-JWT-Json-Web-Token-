package Spring_Security_JWT.auth.OTP.util;



import org.springframework.security.crypto.password.PasswordEncoder;

import Spring_Security_JWT.modules.account.Account;

public class AccountValidationUtil {

    public static void validateAccount(Account account, String password, PasswordEncoder encoder) {
        if (!account.getVerified()) { // ✅ Sử dụng getter đúng kiểu
            throw new AccountNotVerifiedException("Tài khoản chưa được xác thực. Vui lòng xác thực email của bạn!");
        }
        if (account.getStatus() == 0) {
            throw new AccountLockedException("Tài khoản của bạn bị khóa, vui lòng liên hệ quản trị viên!");
        }
        if (!encoder.matches(password, account.getPassword())) {
            throw new InvalidCredentialsException("Sai mật khẩu, vui lòng kiểm tra lại!");
        }
    }
}
