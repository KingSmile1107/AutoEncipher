package com.ks.entity;

public class KeyModel {

    //温度
    Double temperature;

    //湿度
    Double humidity;

    //车牌
    String carId;

    //订单号
    String orderId;

    //时间
    String time;

    //经HEX编码后的算法标识符
    String hexEncryptAlgorithmsId;

    public KeyModel(Double temperature, Double humidity, String carId, String orderId, String time, String hexEncryptAlgorithmsId) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.carId = carId;
        this.orderId = orderId;
        this.time = time;
        this.hexEncryptAlgorithmsId = hexEncryptAlgorithmsId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHexEncryptAlgorithmsId() {
        return hexEncryptAlgorithmsId;
    }

    public void setHexEncryptAlgorithmsId(String hexEncryptAlgorithmsId) {
        this.hexEncryptAlgorithmsId = hexEncryptAlgorithmsId;
    }

    @Override
    public String toString() {
        return "KeyModel{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", carId='" + carId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", time='" + time + '\'' +
                ", hexEncryptAlgorithmsId='" + hexEncryptAlgorithmsId + '\'' +
                '}';
    }
}
