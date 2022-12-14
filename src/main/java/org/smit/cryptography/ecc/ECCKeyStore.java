package org.smit.cryptography.ecc;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.security.SecureRandom;


public class ECCKeyStore {
    public AsymmetricCipherKeyPair keyPair;

    public ECCKeyStore(String type) {

        ECParameterSpec params = ECNamedCurveTable.getParameterSpec(type);

        ECDomainParameters parameters = new ECDomainParameters(params.getCurve(),
                params.getG(), params.getN(), params.getH(),
                params.getSeed());
        SecureRandom random = new SecureRandom();

        ECKeyGenerationParameters generationParameters = new ECKeyGenerationParameters(parameters, random);
        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        generator.init(generationParameters);

        keyPair = generator.generateKeyPair();
    }

    public ECPrivateKeyParameters getPrivateKey(){
        return (ECPrivateKeyParameters) keyPair.getPrivate();
    }

    public ECPublicKeyParameters getPublicKey(){
        return (ECPublicKeyParameters) keyPair.getPublic();
    }
}
