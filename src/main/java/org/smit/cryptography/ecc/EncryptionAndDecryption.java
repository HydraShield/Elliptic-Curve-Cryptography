package org.smit.cryptography.ecc;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

import java.security.SecureRandom;

public class EncryptionAndDecryption {
    public static byte[] Encryption(byte[] message, ECPublicKeyParameters pk){
        SM2Engine engine = new SM2Engine();
        engine.init(true, new ParametersWithRandom(pk, new SecureRandom()));
        try {
            return engine.processBlock(message, 0, message.length);
        } catch (InvalidCipherTextException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] Decryption(byte[] cipher, ECPrivateKeyParameters pk){
        SM2Engine engine = new SM2Engine();
        engine.init(false, pk);
        try {
            return engine.processBlock(cipher, 0, cipher.length);
        } catch (InvalidCipherTextException e) {
            throw new RuntimeException(e);
        }
    }
}
