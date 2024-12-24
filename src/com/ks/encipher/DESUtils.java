package com.ks.encipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DESUtils {

    /**
     * DES加密
     * @param sourceStr 要加密的数据
     * @param key   密钥
     * @return  加密后的数据
     */
    public static byte[] encryptDes(String sourceStr, String key) {
        try {
            if (sourceStr == null || sourceStr.isEmpty()) {
                throw new Exception("原文不能为空！");
            }
            if (key == null || key.isEmpty() || key.length() < 8) {
                throw new Exception("密钥不能为空，且密钥必须大于等于8位！");
            }
            byte[] datasource = sourceStr.getBytes("utf-8");
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes("utf-8"));

            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);

            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");

            //用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);

            //现在，获取数据并加密 正式执行加密操作
            //按单部分操作加密或解密数据，或者结束一个多部分操作
            return cipher.doFinal(datasource);

        } catch (Throwable e) {
            System.out.println("DES 加密异常，详情：" + e.toString());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密
     * @param encodedStr    需要解密的数据
     * @param key   密钥
     * @return  解密后的数据
     * @throws Exception
     */
    public static String decrypt(byte[] encodedStr, String key) throws Exception {
        if (encodedStr == null) {
            throw new Exception("密文不能为空！");
        }

        if (key == null || key.isEmpty() || key.length() < 8) {
            throw new Exception("密钥不能为空，且密钥必须大于等于8位！");
        }

        byte[] src = encodedStr;

        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes("utf-8"));
            // 创建一个密匙工厂
            // 返回实现指定转换的 Cipher 对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return new String(cipher.doFinal(src));
        } catch (Throwable e) {
            System.out.println("DES 解密异常，详情：" + e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
