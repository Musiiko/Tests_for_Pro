package homework5.task3;

public class Check {
    public static boolean uniqueNumbers(int number) {
        int countNum = 0;
        int differNumbers;
        boolean figuresEgual = false;
        differNumbers = number;

        while (differNumbers != 0) {
            ++countNum;
            differNumbers /= 10;
        }

        int[] digits = new int[countNum];
        countNum = 0;
        differNumbers = number;

        while (differNumbers % 10 != 0) {
            digits[countNum++] = differNumbers % 10;
            differNumbers /= 10;
        }

        figuresEgual = false;
        for (int i = 0; i < digits.length; i++) {
            if (figuresEgual) {
                break;
            }
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    figuresEgual = true;
                    break;
                }
            }
        }
        if (figuresEgual == false) {
            return true;
        } else {
            return false;
        }
    }

}
