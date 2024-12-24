package com.ks;

public class Test {
    public static void main(String[] args) {
    // 创建十个变量
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        // 打印数组
        for (int number : numbers) {
            System.out.println(number);
        }
        // 创建一个二维数组
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * matrix[i].length + j + 1;
            }
        }
        // 打印二维数组
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        // 创建一个三维数组
        int[][][] cube = new int[2][2][2];
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = i * cube[i].length * cube[i][j].length + j * cube[i][j].length + k + 1;
                }
            }
        }
    }
}
