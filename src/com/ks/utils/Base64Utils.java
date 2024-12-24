package com.ks.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 对数据进行Base64编码
     * @param encoderText 待编码的字符串
     * @return String Base64编码后的字符串
     */
    public static String Base64Encoder(String encoderText) {
        byte[] textByte = encoderText.getBytes(StandardCharsets.UTF_8);
        return encoder.encodeToString(textByte);
    }

    /**
     * 对数据进行Base64解码
     * @param decodeText 待解码的字符串
     * @return String Base64解码后的字符串
     */
    public static String Base64Decode(String decodeText) {
        return new String(decoder.decode(decodeText), StandardCharsets.UTF_8);
    }

    public static byte[] Base64Encoder(byte[] bytes) {
        return encoder.encode(bytes);
    }

    public static byte[] Base64Decode(byte[] bytes) {
        return decoder.decode(bytes);
    }
}
