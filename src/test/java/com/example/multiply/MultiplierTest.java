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
   
}
