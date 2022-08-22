package TasksFromLeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Mulltiply {

    public static void main(String[] args) {
        multiply("7286", "1324");

    }

    public static String multiply(String num1, String num2) {
    /*

    + Преобразовываем строки num1, num2 в массивы букв arrayOfChararcters1, arrayOfChararcters2.
    +Создаем метод с помощью которого буква изменялась на число.
    +Теперь заполняем массивы чисел массивами букв.
    Создаем переменную остаток от произведения.
    Создаем переменную остаток от суммы.
    Если есть остаток то мы добавляем его к произведению.
    Обнуляем остаток
    Если есть остаток от сложения то мы добавляем к произведению.
    Обнуляем остаток от сложения.



     */
        char[] arrayOfCharacters1 = num1.toCharArray();
        char[] arrayOfCharacters2 = num2.toCharArray();

        int[] firstIntArray = new int[arrayOfCharacters1.length];
        int[] secondIntArray = new int[arrayOfCharacters1.length];

        int[][] arrayOfIntegerResult = new int[secondIntArray.length][secondIntArray.length + firstIntArray.length];


        for (int i = 0; i < arrayOfCharacters1.length; i++) {
            firstIntArray[i] = changeCharToInt(arrayOfCharacters1[i]);
        }

        for (int i = 0; i < arrayOfCharacters2.length; i++) {
            secondIntArray[i] = changeCharToInt(arrayOfCharacters2[i]);
        }
        System.out.println(Arrays.toString(firstIntArray) + " Это первый массив чисел");
        System.out.println(Arrays.toString(secondIntArray) + " Это второй массив чисел");

//        int counterForRow = firstIntArray.length;
//        for (int i = secondIntArray.length; i > 0; i--) {
//            int remainderOfProduce = 0;
//            int counterForColumn = 0;
//            int product = 0;
//            int counter = 0;
//            for (int j = i; j > firstIntArray.length; j--) {
//                product = (firstIntArray[counterForRow - 1] * secondIntArray[secondIntArray.length - counterForColumn - 1] + remainderOfProduce);
//                arrayOfIntegerResult[arrayOfIntegerResult.length - counterForRow][secondIntArray.length + firstIntArray.length - j - counterForColumn - 1] = product % 10; //текущее произведение
//                remainderOfProduce = product / 10; // число в уме
//                counterForColumn++;
//            }
//            counterForRow--;
//
//        }

        int remainderOfProduce = 0;


        int counter = 0;
        int counterForColumn = 0;
        for (int i = 0; i < firstIntArray.length; i++) {

            for (int j = counterForColumn++; j < secondIntArray.length; j++) {

                int product = firstIntArray[firstIntArray.length - i - 1] * secondIntArray[secondIntArray.length - j - 1] + remainderOfProduce;
                arrayOfIntegerResult[i][arrayOfIntegerResult[i].length - j - 1] = product % 10;


            }

        }

//                product = secondIntArray[j] * firstIntArray[j] + remainderOfSum + remainderOfProduce;
//                remainderOfProduce = product / 10;
////                remainderOfSum =
//                if ((arrayOfIntegerResult[i][Math.max(j - 1, 0)] == 0 && j != -1) || (arrayOfIntegerResult[Math.max(i - 1, 0)][j] == 0 && i != -1)) {
//                    arrayOfIntegerResult[i][Math.max(j - 1, 0)] = product % 10;
//
//                    arrayOfIntegerResult[i][Math.max(j - 1, 0)]
//                            += remainderOfProduce;
//                    remainderOfProduce = 0;
//                }
//            }
//        }

        print(arrayOfIntegerResult);
        return num1;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
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

