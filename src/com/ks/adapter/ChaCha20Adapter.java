package com.ks.adapter;

import com.ks.entity.KeyModel;

public class ChaCha20Adapter {

    public static String ChaCha20KeyAdapter(KeyModel keyModel) {
        String temperature = getRemoveDotNum(keyModel.getTemperature());  //6位
        String humidity = getRemoveDotNum(keyModel.getHumidity());    //6位
        String carId = getStrNum(keyModel.getCarId(), 4);      //4位
        String orderId = getStrNum(keyModel.getOrderId(), 8);      //8位
        String time = keyModel.getTime();       //8位

        //需要满足32位
        return time + temperature + humidity + carId + orderId;
    }

    public static String ChaCha20NonceAdapter(KeyModel keyModel) {
        String temperature = getLast2Num(keyModel.getTemperature(), 2);  //2位
        String humidity = getLast2Num(keyModel.getHumidity(), 2);    //2位
        String carId = getStrNum(keyModel.getCarId(), 4);      //4位
        String orderId = getStrNum(keyModel.getOrderId(), 4);      //4位

        //需要满足12位
        return temperature + humidity + carId + orderId;
    }

    public static Integer ChaChaCounterAdapter(KeyModel keyModel) {
        Integer temperature = Integer.parseInt(getLast2Num(keyModel.getTemperature(), 2));  //2位
        Integer humidity = Integer.parseInt(getLast2Num(keyModel.getHumidity(), 2));    //2位

        return temperature + humidity;
    }

    /**
     * 去掉小数点
     * @param num
     * @return
     */
    public static String getRemoveDotNum(Double num) {
        String numStr = String.valueOf(num).replace(".", "");
        return numStr;
    }

    /**
     * 取最后 n 位数
     * @param num
     * @return
     */
    public static String getLast2Num(Double num, Integer index) {
        String numStr = String.valueOf(num);
        return numStr.substring(numStr.length() - index, numStr.length());
    }

    public static String getStrNum(String str, Integer index) {
        return str.substring(str.length() - index, str.length());
    }
}
