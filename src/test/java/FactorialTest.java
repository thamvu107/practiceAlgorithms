import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    private static final String EXCEPTION_MESSAGE = "Negative number is invalid input value.";

    @ParameterizedTest(name = "{0} is invalid input value")
    @MethodSource("provideInvalidTestData")
    @DisplayName("Test invalid data")
    public void testInputNegativeNumber(int invalidInput) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorial(invalidInput));
        assertEquals(EXCEPTION_MESSAGE, exception.getMessage(),
                () -> String.format("Expected exception message for input %d", invalidInput));
    }

    @ParameterizedTest(name = "Factorial of {0} should be {1}")
    @MethodSource("provideValidTestData")
    @DisplayName("Test Factorial Calculation")
    public void testCorrectFactorialCalculation(int input, int expectedFactorial) {

        assertEquals(expectedFactorial, Factorial.factorial(input),
                () -> String.format("Factorial of %d should be %d", input, expectedFactorial));
    }

    // Data provider for factorial calculations
    public static Stream<Arguments> provideValidTestData() {
        return Stream.of(
                Arguments.of(0, 1),           // Factorial of 0 = 1
                Arguments.of(1, 1),           // Factorial of 1 = 1
                Arguments.of(5, 120),         // Factorial of 5 = 120
                Arguments.of(10, 3628800)     // Factorial of 10 = 3628800
        );
    }

    // Data provider for factorial calculations
    public static Stream<Arguments> provideInvalidTestData() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10)
        );
    }

}
