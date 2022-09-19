package homework5.task4;

public class Matrix {
    public static void main(String[] args) {
        int k = 8;
        int n = 1;
        int num = 1;
        System.out.println(getString(k, n, num));
    }

    public static String getString(int k, int n, int num) {
        String strong = "";
        while (n * n < k) {
            n++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num <= k) {
                    strong += num + "\t";
                    num++;
                }
            }
            strong += "\n";
        }
        return strong;
    }


}
