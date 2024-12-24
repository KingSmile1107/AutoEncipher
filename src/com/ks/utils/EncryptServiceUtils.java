package com.ks.utils;

import com.ks.encipher.AESUtils;
import com.ks.encipher.ChaCha20Utils;
import com.ks.encipher.TwoFishUtils;
import com.ks.enums.EncryptAlgorithmsEnum;

public class EncryptServiceUtils {

    /**
     * A2 B2
     * @param useEncrypt
     * @param key
     * @param data
     * @param nonce
     * @param count
     * @return
     * @throws Exception
     */
    public static byte[] runEncode(String useEncrypt, byte[] key, byte[] data, byte[] nonce, int count) throws Exception {
        if (useEncrypt.equals(EncryptAlgorithmsEnum.A2.getUseEncryptAlgorithms())) {
            return ChaCha20Utils.encrypt(data, key, nonce, count);
        }else if (useEncrypt.equals(EncryptAlgorithmsEnum.B2.getUseEncryptAlgorithms())) {
            byte[] reData = ChaCha20Utils.encrypt(data, key, nonce, count);
            return HexUtils.ByteArrayToHexByteArray(reData);
        } else {
            System.err.println("runEncode ERROR!2");
            return null;
        }
    }

    public static byte[] runEncode(String useEncrypt, byte[] key, byte[] data) throws Exception {
        if (useEncrypt.equals(EncryptAlgorithmsEnum.A1.getUseEncryptAlgorithms())) {
            return AESUtils.encodeByECB(data, key);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.A3.getUseEncryptAlgorithms())) {
            return TwoFishUtils.encrypt(data, key);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.B1.getUseEncryptAlgorithms())) {
            byte[] reData = AESUtils.encodeByECB(data, key);
            return Base64Utils.Base64Encoder(reData);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.B3.getUseEncryptAlgorithms())) {
            byte[] reData = TwoFishUtils.encrypt(data, key);
            return Base64Utils.Base64Encoder(reData);
        } else {
            System.err.println("runEncode ERROR!1");
            return null;
        }
    }


    public static byte[] runDecode(String useEncrypt, byte[] key, byte[] data, byte[] nonce, int count) throws Exception {
        if (useEncrypt.equals(EncryptAlgorithmsEnum.A2.getUseEncryptAlgorithms())) {
            return ChaCha20Utils.decrypt(data, key, nonce, count);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.B2.getUseEncryptAlgorithms())) {
            byte[] reData = HexUtils.hexToByteArray(new String(data));
            return ChaCha20Utils.decrypt(reData, key, nonce, count);
        } else {
            System.err.println("runDecode ERROR!2");
            return null;
        }
    }

    public static byte[] runDecode(String useEncrypt, byte[] key, byte[] data) throws Exception {
        if (useEncrypt.equals(EncryptAlgorithmsEnum.A1.getUseEncryptAlgorithms())) {
            return AESUtils.decodeByECB(data, key);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.A3.getUseEncryptAlgorithms())) {
            return TwoFishUtils.decrypt(data, key);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.B1.getUseEncryptAlgorithms())) {
            byte[] reData = Base64Utils.Base64Decode(data);
            return AESUtils.decodeByECB(reData, key);
        } else if (useEncrypt.equals(EncryptAlgorithmsEnum.B3.getUseEncryptAlgorithms())) {
            byte[] reData = Base64Utils.Base64Decode(data);
            return TwoFishUtils.decrypt(reData, key);
        } else {
            System.err.println("runDecode ERROR!1");
            return null;
        }
    }
}
