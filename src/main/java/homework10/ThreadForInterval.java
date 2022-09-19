package homework10;

public class ThreadForInterval extends Thread {
    private final int first;
    private final int last;
    private final Total total;

    public ThreadForInterval(int first, int last, Total total) {
        this.first = first;
        this.last = last;
        this.total = total;
    }

    @Override
    public void run() {
        int[] numbersArray = new int[last - first + 1];
        int[] resultArray = new int[0];
        int temp = first;
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = temp;
            temp++;
        }
        boolean isSimple = true;
        for (int j : numbersArray) {
            for (int g = 2; g <= j / 2; g++) {
                if (j % g == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                resultArray = pushBack(j, resultArray);
            }
            isSimple = true;
        }
        total.toResultArray(resultArray);
        return;
    }

    public int[] pushBack(int a, int[] NumbersArray) {
        int[] temp = NumbersArray;
        NumbersArray = new int[NumbersArray.length + 1];
        System.arraycopy(temp, 0, NumbersArray, 0, temp.length);
        boolean functionCorrect = false;
        for (int i = 0; i < NumbersArray.length; i++) {
            if (NumbersArray[i] == 0) {
                NumbersArray[i] = a;
                functionCorrect = true;
                break;
            }
        }
        if (!functionCorrect) {
            System.out.println("Repeat");
        }
        return NumbersArray;
    }

}