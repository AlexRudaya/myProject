package com.aston.Lesson_5;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый
 * массив размером 4х4. При подаче массива другого размера
 * необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива,
 * преобразовать в int и просуммировать. Если в каком-то элементе
 * массива преобразование не удалось (например, в ячейке лежит
 * символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат
 * неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные
 * исключения MyArraySizeException и MyArrayDataException и вывести
 * результат расчета.
 */

public class Array {
    public static void main(String[] args) {
        String[][] a = {{"5", "33", "3", "5"}, {"5", "7", "6", "3"}, {"5", "7", "3", "17"}, {"5", "7", "3", "17"}};
        String[][] b = {{"5", "33", "3", "5"}, {"5", "not a number", "6", "3"}, {"5", "7", "3", "17"}, {"5", "7", "3", "17"}};
        String[][] c = {{"5", "33", "3", "5"}, {"5", "7", "3", "17"}, {"5", "7", "3", "17"}};
        String[][] d = {{"5", "33", "3", "5"}, {"5", "6", "6", "3"}, {"5", "7", "3", "17"}, {"5", "7", "3"}};

        try {
            System.out.println("Sum of all cells= " + exceptionTest(c));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int exceptionTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Incorrect amount of strings");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Incorrect amount of columns");
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }

        }
        return sum;
    }

}