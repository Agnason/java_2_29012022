package lesson02;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "4", "5", "6"},
                {"1", "6"},
                {"1", "4kjk", "5", "8"},
                {"1", "4", "5", "6"},
        };
        String[][] arr2 = {
                {"1", "4", "5", "6"},
                {"1", "6"},
                {"1", "4", "5", "8"},
                {"1", "4", "5", "6"},
        };
        String[][] arr3 = {
                {"1", "4", "5", "6"},
                {"1", "6"},
                {"1", "4", "5", "8"},
                {"1", "4", "5", "6", "7"},
                {"1", "4", "5", "8"},
                {"1", "4", "5", "8"}
        };
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(arr2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Сумма элементов массива равна " + sumArray(arr3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    /*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    при подаче массива другого размера необходимо бросить исключение MyArraySizeException.*/
    public static void checkArray(String[][] arr) throws MyArraySizeException {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length > 4) {
                throw new MyArraySizeException("В массиве д.б. не более 4 строк." + "У Вас " + arr.length + " строк");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length > 4) {
                    throw new MyArraySizeException("В массиве д.б. не более 4 элементов в каждой строке. " + "У Вас в " + (i + 1) + " строке " + arr[i].length + " элементов.");
                }
            }
        }
    }

    /*2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
    с детализацией в какой именно ячейке лежат неверные данные*/
    /*В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);
Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано), то будет сгенерировано исключение NumberFormatException.
*/
    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        checkArray(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] строкового массива находится не целое число %s.", i, j, arr[i][j]));
                }
            }
        }
        return sum;
    }
}
