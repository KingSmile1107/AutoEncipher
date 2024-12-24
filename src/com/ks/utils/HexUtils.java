package com.ks.utils;

public class HexUtils {

    /**
     * 对数据进行Hex编码
     * @param str 待编码数据
     * @return Hex编码后的数据
     */
    public static String StringToHex(String str) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    /**
     * 对数据进行Hex解码
     * @param str 待解码数据
     * @return Hex解码后的数据
     */
    public static String HexToString(String str) {
        // 添加对输入字符串长度的校验
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid hex string length.");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            String byteStr = str.substring(i, i + 2);
            try {
                int byteValue = Integer.parseInt(byteStr, 16);
                result.append((char) byteValue);
            } catch (NumberFormatException e) {
                // 在这里处理非法的十六进制字符
                throw new IllegalArgumentException("Invalid hex character: " + byteStr, e);
            }
        }
        return result.toString();
    }

    public static byte[] hexToByteArray(String hexString) {
        if (hexString.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid hex string length.");
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            int byteValue = Integer.parseInt(hexString.substring(i, i + 2), 16);
            bytes[i / 2] = (byte) byteValue;
        }
        return bytes;
    }

    public static byte[] ByteArrayToHexByteArray(byte[] byteArray) {
        byte[] hexByteArray = new byte[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            int v = b & 0xFF;
            hexByteArray[index++] = (byte) HEX_CHAR_TABLE[v >>> 4];
            hexByteArray[index++] = (byte) HEX_CHAR_TABLE[v & 0x0F];
        }
        return hexByteArray;
    }

    private static final char[] HEX_CHAR_TABLE = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };



}
