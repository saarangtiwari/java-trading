package com.example.tradingexchange.api.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "TUlJQ0lqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FnOEFNSUlDQ2dLQ0FnRUF0ZGliaEVqdmFhWWhETjlsa3ZrTApIeHlkSXpiYWwrb0tBUzVnZHJCYkx2RzBZWEhXSG1TQ1JrMFpqREkweGxrbFRtK3dUUHZpcHdOdStmbHZMcnFUCnRINHVqR0xUdFlxR3laWU9yTkROSGxVYmpHOUdVNTJYdUdWbFozdkE3UFgxNWNWbC8zYzNwd1E2RXZwTnlQMFAKUHI5L0NMZnlHOCtud05oTUdoWHloSkNkL1pVNE1PS3JyemZyMzY1TDFWVXNKam1jQ1B4OUFsN2Q1b1hFZkQ1UAp4WDlUaHdTZ2d5aVY0SEhHdkxDUTFFUnNpakVVTGQyZSs4K2l5cjEvM1d6QXRucUJtVlVTcHdBeHMyU1NDWW5PCnhCVWY1MGZBcDg4bnM2empDVGdvKzZTRXJWYnNpejJHemxvMHo5b1ZQMUZkejVQS1A0NlRhQ0Y4aVVmZW1KVHEKbW9XdnowRXVQL21ZY2E1KzFmcDh2cDUrUVY3NXh6dTdKeTQyQllvQjZZNDVRNzdaYlAxTTZlbHhYK1d0Mm0wcgozeEt6cDZHY3hGMGdhMXI4SWtWVWtDdWRoa21mZSthdUJSUXM5VkJvMllmZTE2NHhmUzdPaGlLUXNhemhsdnRyClhpbmtxb290aTRhdG01NUhhVHllRmxBV0hLL2tjWmh2ZnlrNjN5QlBSV1NSdHVWZ2RXSjB0YmFFTkJqWUlsdUYKUVNLOTVCcko2ZFdXdzRZd2xDRmVCcVhjSXozUEkwN3JKVENoUGZTU2JyKzJqWVdkY28xemJlZ2dWSlVKcjdBcApwZDNkcllINXVCRFAxMnMycWU4anVZdDdvZVVLK2Q2emw0THQwZ21LUHB0VGFZZUYvVCtvV2VuS29ha0pVNUdpCjBQK1d3WmxmRC80MHN0OUE0TkRURTY4Q0F3RUFBUT09Cg==";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
