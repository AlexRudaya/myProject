package com.aston.Lesson1_2;

import java.util.Arrays;

public class Lesson1_2 {
    public static void main(String args[]) {
//        printThreeWords();
//        checkSumSign();
//        printColor();
//        compareNumbers();
//        System.out.println(compareSumm(5,5));
//        checkPositive(800);
//        System.out.println(checkNumber(-1));
//        printString("test string", 3);
//        System.out.println("Високосный год? " + leapYear(2000) );
//        changedMassive();
//        longMassive();
//        increasedMassive();
//          twoDimensionalMass();
//        oneDimensionalMass(5,8);

    }

    //  №1 task
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    //   №2 task
    public static void checkSumSign() {
        int a = 5;
        int b = -5;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //  №3 task
    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //  №4 task
    public static void compareNumbers() {
        int a = 5;
        int b = 8;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


    //  №5 task
    public static boolean compareSumm(int a, int b) {
        return ((a + b) >= 10 & (a + b) <= 20);
//        {
//            return true;
//        } else {
//            return false;
//        }
    }

    //    №6 task
    public static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    //    №7 task
    public static boolean checkNumber(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //    №8 task
    public static void printString(String s, int a) {
        while (a > 0) {
            System.out.println(s);
            a--;
        }
    }


    // №9 task
    public static boolean leapYear(int a) {
        return (((a % 4 == 0) & (a % 100 != 0)) | (a % 400 == 0));
    }

    // №10 task
    public static void changedMassive() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1};
        System.out.println("Исходный массив " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Измененный массив " + Arrays.toString(arr));
    }

    //      №11 task
    public static void longMassive() {
        int[] arr = new int[100];
        for (int i = 1; i < 101; i++) {
            arr[i - 1] = i;
        }
        System.out.println(Arrays.toString(arr));
    }

    // №12 task
    public static void increasedMassive() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //№13 task
    public static void twoDimensionalMass() {
        int n = 5;
        int i,j;
        int[][] arr = new int[n][n];
        i=0;
        for (j = 0; j < n; j++) {
                arr[i][j] = 1;
                i++;
            }
        j=0;
          for (i = n-1; i>-1; i--){
            arr[i][j] = 1;
            j++;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                //    arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // №14 task
    public static void oneDimensionalMass(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }

}