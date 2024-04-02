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
//         twoDimensionalMass();
//        oneDimensionalMass(5,8);

    }

    //  №1 task
//    1. Создайте метод printThreeWords(), который при вызове
//    должен отпечатать в столбец три слова: Orange, Banana,
//    Apple.
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
//    3. Создайте метод printColor() в теле которого задайте int
//    переменную value и инициализируйте ее любым значением.
//    Если value меньше 0 (0 включительно), то в консоль метод
//    должен вывести сообщение “Красный”, если лежит в
//    пределах от 0 (0 исключительно) до 100 (100 включительно),
//    то “Желтый”, если больше 100 (100 исключительно) -
//            “Зеленый”;
    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
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
//    5. Напишите метод, принимающий на вход два целых числа и
//    проверяющий, что их сумма лежит в пределах от 10 до 20
//            (включительно), если да – вернуть true, в противном случае –
//            false.
    public static boolean compareSumm(int a, int b) {
        return ((a + b) >= 10 & (a + b) <= 20);
//        {
//            return true;
//        } else {
//            return false;
//        }
    }

    //    №6 task
//    6. Напишите метод, которому в качестве параметра передается
//    целое число, метод должен напечатать в консоль,
//    положительное ли число передали или отрицательное.
//    Замечание: ноль считаем положительным числом.
    public static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    //    №7 task
//    Напишите метод, которому в качестве параметра передается
//    целое число. Метод должен вернуть true, если число
//    отрицательное, и вернуть false если положительное.
    public static boolean checkNumber(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //    №8 task
//    8. Напишите метод, которому в качестве аргументов
//    передается строка и число, метод должен отпечатать в
//    консоль указанную строку, указанное количество раз;
    public static void printString(String s, int a) {
        while (a > 0) {
            System.out.println(s);
            a--;
        }
    }


    // №9 task
//    9. Напишите метод, который определяет, является ли год
//    високосным, и возвращает boolean (високосный - true, не
//            високосный - false). Каждый 4-й год является високосным,
//    кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean leapYear(int a) {
        return (((a % 4 == 0) & (a % 100 != 0)) | (a % 400 == 0));
    }

    // №10 task
//    10. Задать целочисленный массив, состоящий из элементов 0
//    и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
//    условия заменить 0 на 1, 1 на 0;
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
//    11. Задать пустой целочисленный массив длиной 100. С
//    помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ...
//            100;
    public static void longMassive() {
        int[] arr = new int[100];
        for (int i = 1; i < 101; i++) {
            arr[i - 1] = i;
        }
        System.out.println(Arrays.toString(arr));
    }

    // №12 task
//    12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по
//    нему циклом, и числа меньшие 6 умножить на 2;
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
//    13. Создать квадратный двумерный целочисленный массив
//            (количество строк и столбцов одинаковое), и с помощью цикла
//(-ов) заполнить его диагональные элементы единицами
//            (можно только одну из диагоналей, если обе сложно).
//    Определить элементы одной из диагоналей можно по
//    следующему принципу: индексы таких элементов равны, то
//    есть [0][0], [1][1], [2][2], ..., [n][n];
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
//    14. Написать метод, принимающий на вход два аргумента: len и
//    initialValue, и возвращающий одномерный массив типа int
//    длиной len, каждая ячейка которого равна initialValue.
    public static void oneDimensionalMass(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }

}