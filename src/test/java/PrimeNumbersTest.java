import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumbersTest {

    @ParameterizedTest
    @MethodSource("primeNumbersProvider")
    @DisplayName("Test prime numbers")
    public void testPrimeNumbers(int number) {
        assertTrue(PrimeNumbers.isPrime(number), number + " should be prime");
    }

    @ParameterizedTest
    @MethodSource("primeNumbersProvider")
    @DisplayName("Test prime numbers")
    public void testSievePrimeNumbers(int number) {
        assertTrue(PrimeNumbers.isPrime(number), number + " should be prime");
    }

    static Stream<Arguments> primeNumbersProvider() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(5),
                Arguments.of(7),
                Arguments.of(11),
                Arguments.of(13),
                Arguments.of(17),
                Arguments.of(19),
                Arguments.of(23)
        );
    }

    @ParameterizedTest
    @MethodSource("nonPrimeNumbersProvider")
    @DisplayName("Test none prime numbers")
    public void testNonPrimeNumbers(int number) {
        assertFalse(PrimeNumbers.isPrime(number), number + " should not be prime");
    }

    static Stream<Arguments> nonPrimeNumbersProvider() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(4),
                Arguments.of(6),
                Arguments.of(8),
                Arguments.of(9),
                Arguments.of(10),
                Arguments.of(12),
                Arguments.of(15),
                Arguments.of(49)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "1, false"
    })
    @DisplayName("Test edge cases of prime numbers")
    public void testEdgeCases(int number, boolean expected) {
        assertEquals(expected, PrimeNumbers.isPrime(number), number + " edge case result should match expected");
    }

}
