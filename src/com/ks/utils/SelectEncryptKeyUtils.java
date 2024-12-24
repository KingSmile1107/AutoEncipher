package com.ks.utils;

import com.ks.adapter.AESAdapter;
import com.ks.adapter.ChaCha20Adapter;
import com.ks.adapter.TwoFishAdapter;
import com.ks.entity.KeyModel;
import com.ks.enums.EncryptAlgorithmsEnum;

import java.util.Map;
import java.util.function.Function;

public class SelectEncryptKeyUtils {

    private static final Map<String, Function<KeyModel, String>> ENCRYPT_KEY_ADAPTERS = Map.of(
            EncryptAlgorithmsEnum.A1.getUseEncryptAlgorithms(), AESAdapter::AESKeyAdapter,
            EncryptAlgorithmsEnum.A2.getUseEncryptAlgorithms(), ChaCha20Adapter::ChaCha20KeyAdapter,
            EncryptAlgorithmsEnum.A3.getUseEncryptAlgorithms(), TwoFishAdapter::TwoFishKeyAdapter,
            EncryptAlgorithmsEnum.B1.getUseEncryptAlgorithms(), AESAdapter::AESKeyAdapter,
            EncryptAlgorithmsEnum.B2.getUseEncryptAlgorithms(), ChaCha20Adapter::ChaCha20KeyAdapter,
            EncryptAlgorithmsEnum.B3.getUseEncryptAlgorithms(), AESAdapter::AESKeyAdapter
    );

    public static String selectEncryptKey(String useEncryptName, KeyModel keyModel) {
        return ENCRYPT_KEY_ADAPTERS.getOrDefault(useEncryptName, SelectEncryptKeyUtils::handleMissingKeyAdapter).apply(keyModel);
    }

    private static String handleMissingKeyAdapter(KeyModel keyModel) {
        System.err.println("selectEncryptKey ERROR!");
        return null;
    }

//    public static String selectEncryptKey(String useEncryptName, KeyModel keyModel) {
//        if (useEncryptName.equals(EncryptAlgorithmsEnum.A1.getUseEncryptAlgorithms())) {
//            return AESAdapter.AESKeyAdapter(keyModel);
//        } else if (useEncryptName.equals(EncryptAlgorithmsEnum.A2.getUseEncryptAlgorithms())) {
//            return ChaCha20Adapter.ChaCha20KeyAdapter(keyModel);
//        } else if (useEncryptName.equals(EncryptAlgorithmsEnum.A3.getUseEncryptAlgorithms())) {
//            return TwoFishAdapter.TwoFishKeyAdapter(keyModel);
//        } else if (useEncryptName.equals(EncryptAlgorithmsEnum.B1.getUseEncryptAlgorithms())) {
//            return AESAdapter.AESKeyAdapter(keyModel);
//        } else if (useEncryptName.equals(EncryptAlgorithmsEnum.B2.getUseEncryptAlgorithms())) {
//            return ChaCha20Adapter.ChaCha20KeyAdapter(keyModel);
//        } else if (useEncryptName.equals(EncryptAlgorithmsEnum.B3.getUseEncryptAlgorithms())) {
//            return AESAdapter.AESKeyAdapter(keyModel);
//        } else {
//            System.err.println("selectEncryptKey ERROR!");
//            return null;
//        }
//    }
}
