package com.ks.encipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class TwoFishUtils {

    private static final String ALGORITHM = "Twofish";
    private static final String TWOFISH_ECB_PADDING = "Twofish/ECB/PKCS5Padding";//Twofish/ECB/PKCS5Padding

    /**
     * Twofish加密
     * @param plainText 需要加密的内容
     * @param key   密钥
     * @return  加密后的内容
     * @throws Exception
     */
    public static byte[] encrypt(byte[] plainText, byte[] key)
            throws Exception {
        Cipher cipher = Cipher.getInstance(TWOFISH_ECB_PADDING);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedText = cipher.doFinal(plainText);
        return encryptedText;
    }

    /**
     * Twofish解密
     * @param cipherText    需要解密的内容
     * @param key   密钥
     * @return  解密后的数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] cipherText, byte[] key)
            throws Exception {
        Cipher cipher = Cipher.getInstance(TWOFISH_ECB_PADDING);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedText = cipher.doFinal(cipherText);
        return decryptedText;
    }
}
