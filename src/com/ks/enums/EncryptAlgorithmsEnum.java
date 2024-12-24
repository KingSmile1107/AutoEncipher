package com.ks.enums;

public enum EncryptAlgorithmsEnum {
    A1("A1", "AES"),
    A2("A2", "ChaCha20"),
    A3("A3", "TwoFish"),
    B1("B1", "AES、Base64"),
    B2("B2", "ChaCha20、HEX"),
    B3("B3", "TwoFish、Base64");

    private String encryptAlgorithmsId;
    private String useEncryptAlgorithms;

    private EncryptAlgorithmsEnum(String encryptAlgorithmsId, String useEncryptAlgorithms) {
        this.encryptAlgorithmsId = encryptAlgorithmsId;
        this.useEncryptAlgorithms = useEncryptAlgorithms;
    }

    public static EncryptAlgorithmsEnum findEncryptAlgorithmsEnumById(String encryptAlgorithmsId) {
        for (EncryptAlgorithmsEnum encryptAlgorithmsEnum : EncryptAlgorithmsEnum.values()) {
            if (encryptAlgorithmsEnum.getEncryptAlgorithmsId().equals(encryptAlgorithmsId)) {
                return encryptAlgorithmsEnum;
            }
        }
        throw new IllegalArgumentException("encryptAlgorithmsId is invalid");
    }

    public String getEncryptAlgorithmsId() {
        return encryptAlgorithmsId;
    }

    public String getUseEncryptAlgorithms() {
        return useEncryptAlgorithms;
    }

    @Override
    public String toString() {
        return "EncryptAlgorithms{" +
                "encryptAlgorithmsId='" + encryptAlgorithmsId + '\'' +
                ", useEncryptAlgorithms='" + useEncryptAlgorithms + '\'' +
                '}';
    }
}
