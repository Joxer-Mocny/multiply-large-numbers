package com.example.multiply;

import java.math.BigInteger;

public class BigIntegerMultiplier implements Multiplier {
    @Override
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();
    }
}