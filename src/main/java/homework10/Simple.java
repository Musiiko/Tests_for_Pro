package homework10;

/* С использованием нескольких потоков выполнения (Thread) реализовать поиск простых чисел внутри заданного диапазона.
Ввести с клавиатуры интервал поиска чисел (например, от 1 до 10000) и число потоков.
Проверку на простоту реализовать самым простым способом: циклом от 2 до числа/2.
Подумать, как разделять интервал поиска по потокам.
Найденные числа должны быть записаны в один общий массив в таком виде, что найденные
простые числа одного потока должны быть расположены подряд.
Написать Unit тесты. */

import java.util.Scanner;

public class Simple {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int firstNumber, lastNumber, amount;
        System.out.print("Please, print the first number: ");
        firstNumber = scan.nextInt();
        System.out.print("Please, print the last number: ");
        lastNumber = scan.nextInt();
        System.out.print("Please, enter the amount of thread: ");
        amount = scan.nextInt();

        start(firstNumber, lastNumber, amount);
    }

    public static int[] start(int firstNumber, int lastNumber, int amount) throws InterruptedException {
        int numbersThread;

        int[] numbersArray = new int[lastNumber - firstNumber + 1];
        for (int i = firstNumber; i <= lastNumber; i++) {
            numbersArray[i - firstNumber] = i;
        }

        int first = 0;
        int last;

        if (numbersArray.length % amount != 0) {
            numbersThread = numbersArray.length / amount + 1;
        } else {
            numbersThread = numbersArray.length / amount;
        }
        last = numbersThread - 1;
        ThreadForInterval[] thread = new ThreadForInterval[amount];
        Total result = new Total();

        for (int i = 0; i < amount; i++) {
            thread[i] = new ThreadForInterval(numbersArray[first], numbersArray[last], result);
            int temp = first;
            first += last - first + 1;
            last += last - temp + 1;
            if (last >= numbersArray.length) {
                last = numbersArray.length - 1;
            }
        }
        for (int i = 0; i < amount; i++) {
            thread[i].start();
        }
        for (int i = 0; i < amount; i++) {
            thread[i].join();
        }
        System.out.println("Numbers:");
        for (int i = 0; i < result.getResultArray().length; i++) {
            if ((i % 30 != 0) || (i == 0)) {
                System.out.print(result.getResultArray()[i] + " ");
            } else {
                System.out.println();
            }
        }
        return result.getResultArray();
    }

}