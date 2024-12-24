package com.ks.utils;

import com.ks.entity.KeySaltModel;
import com.ks.entity.SaveSaltKeyModel;

import static com.ks.Main.saveSaltKeyModel;

public class KeyEncryptUtils {

    public static String keyEncrypt(String key, KeySaltModel keySaltModel) {
        String base64Key = Base64Utils.Base64Encoder(key);
        String saltKey = Base64Utils.Base64Encoder(SHA256Utils.getSha256Str(saltKey(keySaltModel)));

        Integer saltKeyLength = saltKey.length();
        String hexSaltKeyLength = HexUtils.StringToHex(Integer.toOctalString(saltKeyLength));

//        System.out.println("saltKeyLength: " + saltKeyLength);
//        System.out.println("hexSaltKeyLength: " + hexSaltKeyLength);

        saveSaltKeyModel = new SaveSaltKeyModel(base64Key + saltKey, hexSaltKeyLength);

        return base64Key + saltKey;
    }

    public static String saltKey(KeySaltModel keySaltModel) {
        String temperature = String.valueOf(keySaltModel.getTemperature()).replace("." , "_");
        String humidity = String.valueOf(keySaltModel.getHumidity()).replace(".", "_");
        String carId = keySaltModel.getCarId();
        String time = keySaltModel.getTime();

        return temperature + "-" + humidity + "-" + carId + "-" + time;
    }

    public static String removeSaltKey(String key, String length) {
        String hexToStringKey = HexUtils.HexToString(length);
        Integer index = Integer.parseInt(hexToStringKey, 8);
        return key.substring(0, key.length() - index);
    }
}
