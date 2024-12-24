package com.ks.encipher;

import javax.crypto.Cipher;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class ChaCha20Utils {

    private static final String ENCRYPT_ALGO = "ChaCha20";

    /**
     * ChaCha20加密
     * @param plaintext 需要加密的数据
     * @param key   密钥
     * @param nonce 随机数
     * @param counter   计数器
     * @return  返回加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] plaintext, byte[] key, byte[] nonce, int counter) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        SecretKeySpec keySpec = new SecretKeySpec(key, ENCRYPT_ALGO);
        ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, counter);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);

        return cipher.doFinal(plaintext);
    }

    /**
     * ChaCha20解密
     * @param ciphertext    需要解密的数据
     * @param key   密钥
     * @param nonce 随机数
     * @param counter   计数器
     * @return  返回解密后的数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] ciphertext, byte[] key, byte[] nonce, int counter) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        Key keySpec = new SecretKeySpec(key, ENCRYPT_ALGO);
        ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, counter);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);

        return cipher.doFinal(ciphertext);
    }
}

