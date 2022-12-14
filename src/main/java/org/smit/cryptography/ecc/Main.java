package org.smit.cryptography.ecc;

import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ECCKeyStore store = new ECCKeyStore("prime256v1");
        ECCKeyStore store1 = new ECCKeyStore("prime256v1");
//        System.out.println(store.getPrivateKey());
//        System.out.println(store.getPublicKey());
//
//        byte[] m1 = "esutgdjhfdoxfxkghjsofiglxjhbdogcilnkdflibhdfixkucjvh".getBytes();
//        byte[] c1 = EncryptionAndDecryption.Encryption(m1, store.getPublicKey());
//        byte[] m2 = EncryptionAndDecryption.Decryption(c1, store.getPrivateKey());
//
//        System.out.println(new String(m1).equals(new String(m2)));
//
//        BigInteger[] signature = Signer.sign(m1, store.getPrivateKey());
//        System.out.println(Signer.verify(m1, signature[0], signature[1], store.getPublicKey()));

        System.out.println(Arrays.toString(ECDH.generateSecretKey(store1.getPrivateKey(), store.getPublicKey())));

    }
}