package helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.UUID;

public class SetuJwtHelper {
    private String schemedId;
    private String secret;

    public SetuJwtHelper(String schemedId, String secret) {
        this.schemedId = schemedId;
        this.secret = secret;
    }

    public String yieldBearerToken() {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        Date iat = new Date();
        String uid = UUID.randomUUID().toString();
        String token = JWT.create()
                .withAudience(schemedId)
                .withIssuedAt(iat)
                .withClaim("jti", uid)
                .sign(algorithm);
        return "Bearer " + token;
    }

    public void verifyBearerToken(String bearerToken) throws JWTVerificationException {
        bearerToken = bearerToken.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .acceptLeeway(10)
                .withAudience(this.schemedId)
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(bearerToken);
    }
}