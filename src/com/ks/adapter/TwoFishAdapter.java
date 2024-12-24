package com.ks.adapter;

import com.ks.entity.KeyModel;

public class TwoFishAdapter {

    public static String TwoFishKeyAdapter(KeyModel keyModel) {
        String temperature = String.valueOf(getDotNum(keyModel.getTemperature()));  //4位
        String humidity = String.valueOf(getDotNum(keyModel.getHumidity()));    //4位
        String carId = getStrNum(keyModel.getCarId());      //4位
        String orderId = getStrNum(keyModel.getOrderId());      //4位
        String time = keyModel.getTime();       //8位

        //24位
        return time + temperature + humidity + carId + orderId;
    }

    /**
     * 取小数点后 4 位
     * @param num
     * @return
     */
    public static Integer getDotNum(Double num) {
        String numStr = String.valueOf(num);
        int decimalIndex = numStr.indexOf(".");
        String decimalPart = numStr.substring(decimalIndex + 1, decimalIndex + 5);
        return Integer.parseInt(decimalPart);
    }

    public static String getStrNum(String str) {
        return str.substring(str.length()- 4, str.length());
    }

}
