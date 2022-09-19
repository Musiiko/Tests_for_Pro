package homework5.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LengthNumbersTest {
    @Test
    void whenLengthNumbers_thenReturnLongest() {
        int[] input = {4, 777, 111, 42, 88888888, 4321, 1111, 1};
        LengthNumbers finder = new LengthNumbers(input);
        Result result = finder.maxNumber();

        Assertions.assertEquals(88888888, result.number);
        Assertions.assertEquals(8, result.length);
    }

    @Test
    void whenLengthNumbers_thenReturnShortest() {
        int[] input = {4, 777, 111, 42, 88888888, 4321, 1111, 1};
        LengthNumbers finder = new LengthNumbers(input);
        Result result = finder.minNumber();

        Assertions.assertEquals(1, result.number);
        Assertions.assertEquals(1, result.length);
    }

}