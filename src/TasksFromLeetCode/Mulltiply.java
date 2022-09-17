package TasksFromLeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Mulltiply {

    public static void main(String[] args) {
        multiply("999", "0");

    }

    public static String multiply(String num1, String num2) {
        String number = "";
        if (num1.equalsIgnoreCase("0")||num2.equalsIgnoreCase("0") ) {
            number = "0";
            System.out.println(number);
            return number;
        } else {
            char[] arrayOfCharacters1 = num1.toCharArray();
            char[] arrayOfCharacters2 = num2.toCharArray();


            int[] firstIntArray = new int[num1.length()];
            int[] secondIntArray = new int[num2.length()];

            int[][] arrayOfIntegerResult = new int[secondIntArray.length][secondIntArray.length + firstIntArray.length];
            int[] solution = new int[firstIntArray.length + secondIntArray.length];

            for (int i = 0; i < arrayOfCharacters1.length; i++) {
                firstIntArray[i] = changeCharToInt(arrayOfCharacters1[i]);
            }
            for (int i = 0; i < arrayOfCharacters2.length; i++) {
                secondIntArray[i] = changeCharToInt(arrayOfCharacters2[i]);
            }
            System.out.println(Arrays.toString(firstIntArray) + " Это первый массив чисел");
            System.out.println(Arrays.toString(secondIntArray) + " Это второй массив чисел");


            for (int j = 0; j < secondIntArray.length; j++) {
                int remainderOfProduce = 0;
                int remainder = 0;

                for (int i = 0; i < firstIntArray.length; i++) {
                    int produce = firstIntArray[firstIntArray.length - i - 1] * secondIntArray[secondIntArray.length - j - 1]
                            + remainderOfProduce + remainder;
                    arrayOfIntegerResult[j][arrayOfIntegerResult[0].length - i - j - 1] = produce % 10;
                    remainder = produce / 10;
                    if (i == firstIntArray.length - 1 && arrayOfIntegerResult[j][arrayOfIntegerResult[0].length - i - j - 2] == 0) {
                        arrayOfIntegerResult[j][arrayOfIntegerResult[0].length - j - i - 2] = remainder;
                    }
                }
            }
            int remainderOfCounter = 0;

            for (int i = 0; i < arrayOfIntegerResult[0].length; i++) {
                int counter = 0;
                for (int j = 0; j < arrayOfIntegerResult.length; j++) {
                    counter += arrayOfIntegerResult[arrayOfIntegerResult.length - j - 1][arrayOfIntegerResult[0].length - i - 1];
                }
                solution[arrayOfIntegerResult[0].length - i - 1] = (counter + remainderOfCounter) % 10;
                System.out.println(counter + " переменные ");
                remainderOfCounter = (counter + remainderOfCounter) / 10;
                System.out.println(remainderOfCounter);
            }
            for (int i = 0; i < solution.length; i++) {
                number += solution[i];
            }

            if (number.startsWith("0")) {
                number = number.substring(1);
            }
            System.out.println(number);
            System.out.println(Arrays.toString(solution));

            print(arrayOfIntegerResult);
            return number;
        }



    }

    public static void print(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int changeCharToInt(char c) {
        String str = "";
        str = Character.toString(c);
        int result = 0;

        for (int i = 0; i <= 9; i++) {
            String integer = Integer.toString(i);
            if (str.equalsIgnoreCase(integer)) {
                result = i;
                break;
            }
        }
        return result;
    }
}

