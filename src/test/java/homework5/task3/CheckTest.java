package homework5.task3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CheckTest {

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void numberResult(int number, boolean expected) {
        Assertions.assertEquals(expected, Check.uniqueNumbers(number));
    }

    private static Stream<Arguments> provideNumbers() {

        return Stream.of(
                Arguments.of(118888, false),
                Arguments.of(887, false),
                Arguments.of(41, true),
                Arguments.of(186, true),
                Arguments.of(9571, true),
                Arguments.of(12345678, true),
                Arguments.of(333, false),
                Arguments.of(10000, false),
                Arguments.of(77788, false)
        );
    }

}