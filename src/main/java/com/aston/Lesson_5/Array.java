package com.aston.Lesson_5;

public class Array {
    public static void main(String args[]) {
        String[][] a = {{"5", "7", "3","5"}, {"5", "7", "3", "3"},  {"5", "7", "3", "17"},{"5", "7", "3", "17"}};
        String[][] b = {{"5", "7", "3","5"},  {"5", "7", "3", "17"},{"5", "7", "3", "17"}};
        try {exceptionTest(a);exceptionTest(b);}
        catch (MyArraySizeException e) {
            //     e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void exceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length!=4)
        {throw new MyArraySizeException("Incorrect amount of strings");}
        for (int i=0;i< arr.length;i++){
            if (arr[i].length!=4 )  {throw new MyArraySizeException("Incorrect amount of columns");
            };
            for (int j=0; j< arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}