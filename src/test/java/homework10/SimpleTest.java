package homework10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {
    @Test
    public void testMainStart() throws InterruptedException {
        int first = 3;
        int last = 19;
        int[][] array = {{3, 5, 7}, {11, 13}, {17, 19}};
        int[] temp = Simple.start(first, last, 3);
        assertTrue(subArrayCheck(temp, array[0]));
        assertTrue(subArrayCheck(temp, array[1]));
        assertTrue(subArrayCheck(temp, array[2]));
        assertEquals(temp.length, 7);
    }

    boolean subArrayCheck(int[] mainArray, int[] subArray) {
        int correct = 1;
        if (mainArray.length > subArray.length) {
            for (int i = 0; i < mainArray.length; i++) {
                for (int value : subArray) {
                    if (mainArray[i] == value) {
                        for (int j = 1; j < subArray.length; j++) {
                            if (subArray[j] == mainArray[i + j]) {
                                correct++;
                                if (correct == subArray.length) {
                                    return true;
                                }
                            }
                        }
                    }
                    correct = 1;
                }
            }
        }
        return false;
    }

}