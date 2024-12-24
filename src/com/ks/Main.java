package com.ks;

import com.ks.adapter.ChaCha20Adapter;
import com.ks.entity.F_EncryptId;
import com.ks.entity.KeyModel;
import com.ks.entity.KeySaltModel;
import com.ks.entity.SaveSaltKeyModel;
import com.ks.enums.EncryptAlgorithmsEnum;
import com.ks.utils.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static final String CHACHA20 = "ChaCha20";

    //Test saveSaltKeyModel
    public static SaveSaltKeyModel saveSaltKeyModel;

    public static Date date = new Date();
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    public static KeyModel keyModel;

    public static byte[] data = encryptData("武汉-北京123==&。/ .d dad123456#");     //需要加密的数据

    public static String encryptId;     //加密算法ID
    public static String useEncryptAlgorithm;       //所使用的加密算法
    public static byte[] key;   //原始密钥
    public static byte[] useKey;    //真正使用的加Salt后的密钥

    public static byte[] test;    //加密后的数据
    public static byte[] test2;   //解密后的数据

    public static long startTime;   //记录开始时间

    public static void main(String[] args) throws Exception {
        //初始化
        init();

        startTime = System.currentTimeMillis();     //记录程序开始运行的时间

        encryptId = SelectEncryptIdUtils.finalEncryptId(new F_EncryptId(5, 3, 2, 0.5, 0.3, 0.2));  //计算加密算法标识符

        useEncryptAlgorithm = EncryptAlgorithmsEnum.findEncryptAlgorithmsEnumById(encryptId).getUseEncryptAlgorithms();        //使用的加密算法
        System.out.println("使用的加密算法: " + useEncryptAlgorithm);

        keyModel = new KeyModel(22.6215, 45.6743, "XYZ123", "ABCD4567890", "20231224", HexUtils.StringToHex(encryptId));

        //生成原始密钥
        generateOriginalKey(useEncryptAlgorithm);

        //对密钥进行加Salt操作
        addSaltKeyMethod(new KeySaltModel(27.1654, 30.0123, "ABC123", formatter.format(date)), key);

        //对密钥进行消Salt操作
        handleKeySalt();

        //加密操作
        performEncryption(useEncryptAlgorithm);

        //解密操作
        performDecryption(useEncryptAlgorithm);

        System.out.printf("全部流程执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
    }

    /**
     * 初始化
     */
    public static void init() {
        Security.addProvider(new BouncyCastleProvider());   //*****must
    }

    /**
     * 生成原始密钥
     * @param useEncryptAlgorithm
     */
    public static void generateOriginalKey(String useEncryptAlgorithm) {
        long startTime = System.currentTimeMillis();
        key = SelectEncryptKeyUtils.selectEncryptKey(useEncryptAlgorithm, keyModel).getBytes();
        System.out.println("原始密钥: " + new String(key));
        System.out.printf("生成原始密钥执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
    }

    /**
     * 对密钥进行消Salt
     */
    public static void handleKeySalt() {
        long startTime = System.currentTimeMillis();
        String removeSaltKey = removeSaltMethod(saveSaltKeyModel);
        useKey = removeSaltKey.getBytes(); // 使用消Salt步骤后获取的密码
        System.out.printf("对密钥进行消Salt执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
    }

    /**
     * 加密操作
     * @param useEncryptAlgorithm
     * @throws Exception
     */
    public static void performEncryption(String useEncryptAlgorithm) throws Exception {
        long startTime = System.currentTimeMillis();
        test = useEncryptAlgorithm.contains(CHACHA20) ?
                EncryptServiceUtils.runEncode(useEncryptAlgorithm, useKey, data, ChaCha20Adapter.ChaCha20NonceAdapter(keyModel).getBytes(), ChaCha20Adapter.ChaChaCounterAdapter(keyModel)) :
                EncryptServiceUtils.runEncode(useEncryptAlgorithm, useKey, data);
        System.out.printf("加密执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
        System.out.println("加密后的数据：" + new String(test));
    }

    /**
     * 解密操作
     * @param useEncryptAlgorithm
     * @throws Exception
     */
    public static void performDecryption(String useEncryptAlgorithm) throws Exception {
        long startTime = System.currentTimeMillis();
        test2 = useEncryptAlgorithm.contains(CHACHA20) ?
                EncryptServiceUtils.runDecode(useEncryptAlgorithm, useKey, test, ChaCha20Adapter.ChaCha20NonceAdapter(keyModel).getBytes(), ChaCha20Adapter.ChaChaCounterAdapter(keyModel)) :
                EncryptServiceUtils.runDecode(useEncryptAlgorithm, useKey, test);
        System.out.println("解密后的数据：" + new String(test2));
        System.out.printf("解密执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
    }

    /**
     * 加密数据
     * @param data  需要加密的字符串
     * @return  getBytes()后的数据
     */
    public static byte[] encryptData(String data) {
        byte[] reData = data.getBytes();
        System.out.println("需要加密的数据: " + data);
        return reData;
    }

    public static String addSaltKeyMethod(KeySaltModel keySaltModel, byte[] key) {
        long startTime = System.currentTimeMillis();
        String addSaltKey = KeyEncryptUtils.keyEncrypt(new String(key), keySaltModel);
        System.out.println("加Salt且Base64编码后的密码: " + addSaltKey);
        System.out.printf("加Salt且Base64编码执行时长：%d 毫秒.\n", (System.currentTimeMillis() - startTime));
        return addSaltKey;
    }

    public static String removeSaltMethod(SaveSaltKeyModel saveSaltKeyModel) {
        String removeSaltKey = Base64Utils.Base64Decode(KeyEncryptUtils.removeSaltKey(saveSaltKeyModel.getAddSaltKey(), saveSaltKeyModel.getHexLength()));
        System.out.println("消Salt后的密码：" + removeSaltKey);
        return removeSaltKey;
    }
}