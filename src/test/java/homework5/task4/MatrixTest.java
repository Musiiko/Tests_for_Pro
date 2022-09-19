package homework5.task4;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void test() {
        int k = 8;
        int n = 1;
        int num = 1;

        String output = "1\t2\t3\t\n4\t5\t6\t\n7\t8\t\n";
        String result = Matrix.getString(k, n, num);
        assertEquals(output, result);
    }
}