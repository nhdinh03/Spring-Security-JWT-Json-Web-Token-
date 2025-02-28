package Spring_Security_JWT.auth.security.services;


import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Spring_Security_JWT.auth.models.RefreshToken;
import Spring_Security_JWT.auth.repository.RefreshTokenRepository;
import Spring_Security_JWT.auth.security.jwt.exception.TokenRefreshException;
import Spring_Security_JWT.modules.account.AccountDAO;
import jakarta.transaction.Transactional;

@Service
public class RefreshTokenService {
    @Value("${bezkoder.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private AccountDAO dao;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(String userId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(dao.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),
                    "Mã thông báo làm mới đã hết hạn. Vui lòng thực hiện yêu cầu đăng nhập mới");
        }

        return token;
    }

    @Transactional
    public int deleteByAccountId(String userId) {
        return refreshTokenRepository.deleteByAccount(dao.findById(userId).get());
    }
}
