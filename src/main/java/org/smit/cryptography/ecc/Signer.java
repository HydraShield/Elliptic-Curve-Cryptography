package org.smit.cryptography.ecc;

import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;

import java.math.BigInteger;

public class Signer {
    public static BigInteger[] sign(byte[] message, ECPrivateKeyParameters pk){
        ECDSASigner signer = new ECDSASigner();
        signer.init(true, pk);
        return signer.generateSignature(message);
    }

    public static boolean verify(byte[] message, BigInteger r, BigInteger s, ECPublicKeyParameters pk){
        ECDSASigner signer = new ECDSASigner();
        signer.init(false, pk);
        return signer.verifySignature(message, r, s);
    }
}
