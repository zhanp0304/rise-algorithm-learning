package org.rise.learning.test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomNumberGenerator
 *
 * @author zhanpeng.jiang@hand-china.com 2023/10/10
 */
public class RandomNumberGenerator {

    private static final int DEFAULT_NUMBER_OF_DIGITS = 8;

    public static String generateRandomNumber() {
        return generateRandomNumber(DEFAULT_NUMBER_OF_DIGITS);
    }

    public static String generateRandomNumber(int numberOfDigits) {
        if (numberOfDigits <= 0) {
            throw new IllegalArgumentException("numberOfDigits must be positive");
        }
        // Generate a random integer between 0 (inclusive) and 99,999,999 (inclusive)
        long randomNumber = ThreadLocalRandom.current().nextLong((long) Math.pow(10, numberOfDigits));

        // Format the random number as an 8-digit string with leading zeros
        StringBuilder randomString = new StringBuilder(Long.toString(randomNumber));
        while (randomString.length() < numberOfDigits) {
            randomString.insert(0, "0");
        }
        return randomString.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            String s = RandomNumberGenerator.generateRandomNumber(10);
            System.out.println(s);
        }
    }
}
