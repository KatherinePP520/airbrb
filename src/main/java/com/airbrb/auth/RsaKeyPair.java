package com.airbrb.auth;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RsaKeyPair {
    public static KeyPairGenerator kpg;
    public static KeyPair kp;
    public static RSAPublicKey rsaPublicKey;
    public static RSAPrivateKey rsaPrivateKey;
    static {
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            kp = kpg.generateKeyPair();
            rsaPublicKey = (RSAPublicKey) kp.getPublic();
            rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
        } catch (NoSuchAlgorithmException e) {
        }
    }
}
