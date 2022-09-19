package homework5.task2;


public class LengthNumbers {
    int[] array;

    public LengthNumbers(int[] array) {
        this.array = array;
    }

    public Result maxNumber() {
        int maxNum = 0;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            int length = 1;
            int num = array[i];
            while (num / 10 >= 1) {
                length++;
                num /= 10;
            }
            if (length >= maxLength) {
                maxNum = array[i];
                maxLength = length;
            }
        }
        System.out.println("Last max long number is: " + maxNum + ". It's length is: " + maxLength);
        return new Result(maxNum, maxLength);
    }

    public Result minNumber() {
        int minNum = array[0];
        int minLength = 0;

        for (int i = 0; i < array.length; i++) {
            int length = 1;
            int num = array[i];
            while (num / 10 >= 1) {
                length++;
                num /= 10;
            }
            if (i == 0) {
                minLength = length;
            }
            if (length <= minLength) {
                minNum = array[i];
                minLength = length;
            }
        }
        System.out.println("Last min long number is: " + minNum + ". It's length is:" + minLength);
        return new Result(minNum, minLength);
    }

}


