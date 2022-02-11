package lesson05;

// Необходимо написать два метода, которые делают следующее:
//1) Создают одномерный длинный массив, например:
//2) Заполняют этот массив единицами.
//3) Засекают время выполнения: long a = System.currentTimeMillis().
//4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//5) Проверяется время окончания метода System.currentTimeMillis().
//6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).

public class MainApp {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        for (float element : arr) {
            element = 1.0f;
        }
        // Один поток
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

        // Два потока
        long startTimeTwoThread = System.currentTimeMillis();
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);

        Thread threadLeftHalf = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("End one thread");
        });
        Thread threadRightHalf = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("End two thread");
        });

        threadLeftHalf.start();
        threadRightHalf.start();

        try {
            threadLeftHalf.join();
            threadRightHalf.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftHalf, 0, arr, 0, HALF);
        System.arraycopy(rightHalf, 0, arr, HALF, HALF);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTimeTwoThread) + " ms.");
    }
}
