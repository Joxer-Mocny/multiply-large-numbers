package com.example.multiply;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplierTest {

    @Test
    void bothAlgorithmsShouldReturnSameResult() {
        String num1 = "12345678901234567890";
        String num2 = "11111111111111111111";

        Multiplier big = new BigIntegerMultiplier();
        Multiplier manual = new ManualMultiplier();

        String resultBig = big.multiply(num1, num2);
        String resultManual = manual.multiply(num1, num2);

        System.out.println("BigInteger: " + resultBig);
        System.out.println("Manual:     " + resultManual);

        assertEquals(resultBig, resultManual);
    }

    @Test
    void multiplyByZeroShouldReturnZero() {
        Multiplier manual = new ManualMultiplier();
        String result = manual.multiply("0", "123456789123456789");
        assertEquals("0", result);
    }

    @Test
    void multiplyByOneShouldReturnSameNumber() {
        Multiplier manual = new ManualMultiplier();
        String result = manual.multiply("1", "999999999999999999");
        assertEquals("999999999999999999", result);
    }

    @Test
    void leadingZerosShouldBeIgnored() {
        Multiplier manual = new ManualMultiplier();
        String result = manual.multiply("0000123", "0000456");
        assertEquals("56088", result);
    }

    @Test
    void veryLargeNumbersShouldBeCorrect() {
        String num1 = "123456789012345678901234567890";
        String num2 = "987654321098765432109876543210";

        Multiplier big = new BigIntegerMultiplier();
        Multiplier manual = new ManualMultiplier();

        String resultBig = big.multiply(num1, num2);
        String resultManual = manual.multiply(num1, num2);

        assertEquals(resultBig, resultManual);
    }

    @Test
    void performanceShouldBeReasonable() {
        String num1 = "9".repeat(1000);
        String num2 = "9".repeat(1000);

        Multiplier manual = new ManualMultiplier();
        long start = System.currentTimeMillis();
        manual.multiply(num1, num2);
        long end = System.currentTimeMillis();

        long duration = end - start;
        System.out.println("Manual multiplication of 1000-digit numbers took: " + duration + " ms");
        assertTrue(duration < 5000, "Performance test took too long: " + duration + " ms");
    }

    @Test
    void invalidInputShouldThrowException() {
        Multiplier manual = new ManualMultiplier();
        assertThrows(IllegalArgumentException.class, () -> manual.multiply("123abc", "456"));
        assertThrows(IllegalArgumentException.class, () -> manual.multiply("123", "!@#"));
    }
}
