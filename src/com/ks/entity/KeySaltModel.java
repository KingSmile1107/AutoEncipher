package com.ks.entity;

public class KeySaltModel {

    //温度
    Double temperature;

    //湿度
    Double humidity;

    //车牌
    String carId;

    //时间戳
    String time;

    public KeySaltModel(Double temperature, Double humidity, String carId, String time) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.carId = carId;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "KeySaltModel{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", carId='" + carId + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}