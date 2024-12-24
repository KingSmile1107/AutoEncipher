package com.ks.entity;

public class SaveSaltKeyModel {

    private String addSaltKey;

    private String hexLength;

    public SaveSaltKeyModel(String addSaltKey, String hexLength) {
        this.addSaltKey = addSaltKey;
        this.hexLength = hexLength;
    }

    public String getAddSaltKey() {
        return addSaltKey;
    }

    public void setAddSaltKey(String addSaltKey) {
        this.addSaltKey = addSaltKey;
    }

    public String getHexLength() {
        return hexLength;
    }

    public void setHexLength(String hexLength) {
        this.hexLength = hexLength;
    }

    @Override
    public String toString() {
        return "SaveSaltKeyModel{" +
                "addSaltKey='" + addSaltKey + '\'' +
                ", hexLength='" + hexLength + '\'' +
                '}';
    }
}
