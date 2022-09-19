package homework10;

public class Total {
    private int[] resultArray;

    public Total() {
        resultArray = new int[0];
    }

    public synchronized void toResultArray(int[] arrayAdd) {
        int[] temp = resultArray;
        resultArray = new int[resultArray.length + arrayAdd.length];
        System.arraycopy(temp, 0, resultArray, 0, temp.length);
        System.arraycopy(arrayAdd, 0, resultArray, temp.length, arrayAdd.length);
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }
}


