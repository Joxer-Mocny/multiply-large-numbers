package com.example.multiply;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java -jar multiply.jar --alg1|--alg2 <number1> <number2>");
            return;
        }

        String algorithm = args[0];
        String num1 = args[1];
        String num2 = args[2];

        if (!num1.matches("\\d+") || !num2.matches("\\d+")) {
            System.err.println("Both numbers must be positive integers.");
            return;
        }

        Multiplier multiplier = switch (algorithm) {
            case "--alg1" -> new BigIntegerMultiplier();
            case "--alg2" -> new ManualMultiplier();
            default -> {
                System.err.println("Invalid algorithm selection. Use --alg1 or --alg2.");
                yield null;
            }
        };

        if (multiplier != null) {
            String result = multiplier.multiply(num1, num2);
            System.out.println(result);
        }
    }
}
