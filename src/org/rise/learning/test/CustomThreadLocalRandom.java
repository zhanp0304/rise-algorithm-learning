package org.rise.learning.test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.SplittableRandom;
import java.util.concurrent.atomic.AtomicLong;

public class CustomThreadLocalRandom {
    private static final ThreadLocal<CustomThreadLocalRandom> THREAD_LOCAL_RANDOM =
            ThreadLocal.withInitial(CustomThreadLocalRandom::new);

    private final AtomicLong seed = new AtomicLong();

    private SplittableRandom splittableRandom;

    private CustomThreadLocalRandom() {
        byte[] seedBytes = SecureRandom.getSeed(8);
        this.seed.set(bytesToLong(seedBytes));
        splittableRandom = new SplittableRandom(this.seed.get());
    }

    public static void remove() {
        THREAD_LOCAL_RANDOM.remove();
    }

    public static CustomThreadLocalRandom current() {
        return THREAD_LOCAL_RANDOM.get();
    }

    public int nextInt() {
        // Use the currentSeed to generate a random number
//        return 10_000_000 + splittableRandom.nextInt(90_000_000);
        return splittableRandom.nextInt();
    }

    public int nextInt(int digit) {
        if (digit < 1) {
            throw new IllegalArgumentException("Number of digit must be at least 1.");
        }

        int minValue = (int) Math.pow(10, (double) digit - 1);
        int maxValue = (int) Math.pow(10, digit) - 1;

        return minValue + splittableRandom.nextInt(maxValue - minValue + 1);
    }

    public void setSeedFromSecureRandom() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            // 8 bytes for a long seed (2 ^ 64)
            byte[] seedBytes = secureRandom.generateSeed(8);
            long newSeed = bytesToLong(seedBytes);
            seed.set(newSeed);
            splittableRandom = new SplittableRandom(seed.get());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SecureRandom initialization failed.", e);
        }
    }

    private static long bytesToLong(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result = (result << 8) | (bytes[i] & 0xFF);
        }
        return result;
    }

    public static void main(String[] args) {
        CustomThreadLocalRandom random = CustomThreadLocalRandom.current();

        // Generate random numbers
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(8);
            System.out.println("Random number: " + randomNumber);
        }

        // Change the seed dynamically from SecureRandom
        random.setSeedFromSecureRandom();

        // Generate more random numbers with the new seed
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(8);
            System.out.println("Random number (new seed): " + randomNumber);
        }
    }
}

