package xyz.mizan.multimodule.auth.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import xyz.mizan.multimodule.auth.service.UserDetailsImpl;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class JwtTokenUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(JwtTokenUtils.class);

	private static String JWT_SECRET = "phaseminus-example";
	private static int JWT_EXPIRATION_MS = 86400000;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION_MS))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			LOG.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			LOG.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			LOG.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			LOG.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			LOG.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}