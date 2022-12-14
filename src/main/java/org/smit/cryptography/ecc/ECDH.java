package org.smit.cryptography.ecc;

import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;

import javax.crypto.KeyAgreement;
import java.security.Key;

public class ECDH {
    public static byte[] generateSecretKey(ECPrivateKeyParameters sk, ECPublicKeyParameters pk){
        try {
            KeyAgreement ka = KeyAgreement.getInstance("ECDH", "BC");
            ka.init((Key) sk);
            ka.doPhase((Key) pk, true);
            return ka.generateSecret();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
