package com.ks.utils;

import com.ks.entity.F_EncryptId;
import com.ks.enums.EncryptAlgorithmsEnum;

import java.util.Random;

public class SelectEncryptIdUtils {

    public final static String A = "A";
    public final static String B = "B";

    //选择哪种类型算法的值
    public final static double THRESHOLD = 3;

    public static double selectEncryptF() {
        return 0.4*1 + 0.3*1 + 0.3*1;
    }

    public static double selectEncryptF(F_EncryptId fEncryptId) {
        // 从对象中提取值
        double wS = fEncryptId.getW_S();
        double wV = fEncryptId.getW_V();
        double wT = fEncryptId.getW_T();
        double s = fEncryptId.getS();
        double v = fEncryptId.getV();
        double t = fEncryptId.getT();

        // 检查权重之和是否为1，并且每个权重和特征都在合适的范围内
        if (isSumOneAndInRange(wS, wV, wT) && isInRange(s, 0, 10) && isInRange(v, 0, 10) && isInRange(t, 0, 10)) {
            return wS * s + wV * v + wT * t;
        } else {
            System.err.println("S、V、T的值设置出错，已启用默认值！");
            return selectEncryptF();
        }
    }

    public static String selectFirstId(double F) {
        if (F < 0) {
            return "ERROR";
        }
        if (F > THRESHOLD) {
            return B;
        } else {
            return A;
        }
    }

    public static Integer selectEncryptG(String encryptType) {
        if (encryptType.equals(A) || encryptType.equals(B)) {
            int aNums = 0, bNums = 0;
            for (EncryptAlgorithmsEnum algorithms : EncryptAlgorithmsEnum.values()) {
                if (algorithms.getEncryptAlgorithmsId().contains(A)) {
                    aNums++;
                } else if (algorithms.getEncryptAlgorithmsId().contains(B)) {
                    bNums++;
                }
            }

            Random random = new Random();
            int selectRandomId;

            if (encryptType.equals(A)) {
                selectRandomId = random.nextInt(aNums, (2 * aNums + 1));
                return (selectRandomId % aNums == 0) ? aNums : selectRandomId % aNums;
            } else if (encryptType.equals(B)) {
                selectRandomId = random.nextInt(bNums, (2 * bNums + 1));
                return (selectRandomId % bNums == 0) ? bNums : selectRandomId % bNums;
            } else {
                System.err.println("selectEncryptG error!");
                return null;
            }
        } else {
            return -1;
        }
    }

    public static String finalEncryptId(F_EncryptId fEncryptId) {
        String res = SelectEncryptIdUtils.selectFirstId(
                SelectEncryptIdUtils.selectEncryptF(fEncryptId));

        Integer id = SelectEncryptIdUtils.selectEncryptG(res);

        return res + id;
    }

    public static String finalEncryptId() {
        String res = SelectEncryptIdUtils.selectFirstId(selectEncryptF());

        Integer id = SelectEncryptIdUtils.selectEncryptG(res);

        return res + id;
    }

    // 检查三个数的和是否为1，并且每个数都在0和1之间
    private static boolean isSumOneAndInRange(double... values) {
        double sum = 0;
        for (double value : values) {
            if (!isInRange(value, 0, 1)) {
                return false;
            }
            sum += value;
        }
        return sum == 1;
    }

    // 检查一个数是否在指定的范围内（包括边界）
    private static boolean isInRange(double value, double min, double max) {
        return value > min && value <= max;
    }
}
