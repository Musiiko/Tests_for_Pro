package homework5.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void whenCheck_thenReturnBoolean() {
        int[] arrayN = {0, 2, 4, 6, 3, -1, 1};
        int[] arrayK = {4, 6, 3};
        Main main = new Main();
        boolean result = Main.check(arrayN, arrayK);

        Assertions.assertEquals(true, result);
    }

}