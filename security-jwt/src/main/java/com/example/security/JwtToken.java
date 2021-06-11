package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt令牌
 */
@ConfigurationProperties(prefix = "myapp.jwt")
@Component
public class JwtToken {

	private String secret;

	private Long expire;

	private String header;

	public JwtToken() {
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * 生成令牌
	 * @param user 用户
	 * @return 令牌
	 */
	public String generateToken(UserDetails user) {
		Map<String, Object> claims = new HashMap<>(2);
		claims.put(Claims.SUBJECT, user.getUsername());
		claims.put(Claims.ISSUED_AT, new Date());
		return generateToken(claims);
	}

	/**
	 * 生成令牌
	 * @param claims 数据声明
	 * @return 令牌
	 */
	private String generateToken(Map<String, Object> claims) {
		Date expirationDate = new Date(System.currentTimeMillis() + this.expire);
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, this.secret)
				.compact();
	}

	/**
	 * 从令牌中获取数据声明
	 * @param token 令牌
	 * @return 数据声明
	 */
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * 判断令牌是否过期
	 * @param token 令牌
	 * @param expiration 过期时间
	 * @return 是否过期
	 */
	public Boolean isTokenExpired(String token, Date expiration) {
		try {
			if (expiration == null) {
				Claims claims = getClaimsFromToken(token);
				expiration = claims.getExpiration();
			}
			return expiration.before(new Date());
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * 刷新令牌
	 * @param token 原令牌
	 * @return 新令牌
	 */
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			Claims claims = getClaimsFromToken(token);
			claims.put(Claims.ISSUED_AT, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	/**
	 * 验证令牌
	 * @param token 令牌
	 * @return username
	 */
	public String validateToken(String token) {
		if (!StringUtils.hasLength(token)) {
			return null;
		}
		Claims claims = getClaimsFromToken(token);
		if (claims == null) {
			return null;
		}
		if (isTokenExpired(null, claims.getExpiration())) {
			return null;
		}
		return claims.getSubject();
	}
	
}
