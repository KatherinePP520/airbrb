package com.airbrb.auth;

import com.airbrb.domain.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import static com.airbrb.auth.RsaKeyPair.rsaPrivateKey;
import static com.airbrb.auth.RsaKeyPair.rsaPublicKey;

public class JwtToken {
    public static Token generateToken(String email){
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            //
            String token = JWT.create()
                    .withSubject(email)
                    .sign(algorithm);
            System.out.println(token);
            return new Token(token);
        } catch (
                JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
        }

        return null;
    }

    public static String verifyToken(String token) {
        System.out.println(token);
        token = token.replace("Bearer ", "");
        System.out.println(token);
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(token);
            System.out.println(decodedJWT.getSubject());
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            // Invalid signature/claims
            System.out.println(exception.getLocalizedMessage());
        }

        return null;

    }

}
