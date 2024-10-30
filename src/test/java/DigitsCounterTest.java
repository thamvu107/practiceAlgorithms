import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitsCounterTest {
    @ParameterizedTest (name = "{0} has {1} digits")
    @MethodSource("provideCountDigitsTestData")
    @DisplayName("Test count Digits")
    public void testCountDigits(int number, int expectedDigits){
        int actualDigits = DigitsCounter.countDigits(number);
        assertEquals(expectedDigits, actualDigits,
                ()-> String.format("Digits of number %d should be %d", number, actualDigits));

    }

    public static Stream<Arguments> provideCountDigitsTestData(){
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(9, 1),
                Arguments.of(10, 2),
                Arguments.of(99, 2),
                Arguments.of(100, 3),
                Arguments.of(9999, 4),
                Arguments.of(123456789, 9)
                );

    }
}
