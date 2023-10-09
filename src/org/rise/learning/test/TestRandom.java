package org.rise.learning.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

/**
 * Description
 *
 * @author zhanpeng.jiang@hand-china.com 2023/10/9
 */
public class TestRandom {
    public static void main(String[] args) {
        testCustomThreadLocalRandom();
        testRandom();
        testSplittableRandom();
    }

    private static void testCustomThreadLocalRandom() {
        CustomThreadLocalRandom random = CustomThreadLocalRandom.current();
        int sampleSize = 1_000_000; // Adjust the sample size as needed

        List<Integer> samples = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            int randomNumber = random.nextInt(8); // Adjust the number of digits as needed
            samples.add(randomNumber);
        }

        // Calculate mean and variance
        double mean = samples.stream().mapToInt(Integer::intValue).average().orElse(0);
        double variance = samples.stream().mapToDouble(x -> Math.pow(x - mean, 2)).sum() / (sampleSize - 1);

        double idealMean = (Math.pow(10, 8) - 1) / 2.0; // Ideal mean for [0, 8] (8 digits)
        double idealVariance = ((Math.pow(10, 8) + 1) * (Math.pow(10, 8) - 1)) / 12.0; // Ideal variance for [0, 8] (8 digits)


        System.out.println("CustomThreadLocalRandom Mean: " + mean);
        System.out.println("CustomThreadLocalRandom Variance: " + variance);
        System.out.println("CustomThreadLocalRandom idealMean: " + idealMean);
        System.out.println("CustomThreadLocalRandom idealVariance: " + idealVariance);
    }

    private static void testRandom() {
        Random random = new Random();
        int sampleSize = 1_000_000; // Adjust the sample size as needed

        List<Integer> samples = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            int randomNumber = random.nextInt(100_000_000); // Adjust the number of digits as needed
            samples.add(randomNumber);
        }

        // Calculate mean and variance
        double mean = samples.stream().mapToInt(Integer::intValue).average().orElse(0);
        double variance = samples.stream().mapToDouble(x -> Math.pow(x - mean, 2)).sum() / (sampleSize - 1);

        double idealMean = (Math.pow(10, 8) - 1) / 2.0; // Ideal mean for [0, 8] (8 digits)
        double idealVariance = ((Math.pow(10, 8) + 1) * (Math.pow(10, 8) - 1)) / 12.0; // Ideal variance for [0, 8] (8 digits)



        System.out.println("Random Mean: " + mean);
        System.out.println("Random Variance: " + variance);

        System.out.println("Random idealMean: " + idealMean);
        System.out.println("Random idealVariance: " + idealVariance);
    }

    private static void testSplittableRandom() {
        SplittableRandom random = new SplittableRandom();
        int sampleSize = 1_000_000; // Adjust the sample size as needed

        List<Integer> samples = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            int randomNumber = random.nextInt(100_000_000); // Adjust the number of digits as needed
            samples.add(randomNumber);
        }

        // Calculate mean and variance
        double mean = samples.stream().mapToInt(Integer::intValue).average().orElse(0);
        double variance = samples.stream().mapToDouble(x -> Math.pow(x - mean, 2)).sum() / (sampleSize - 1);

        // Calculate ideal mean and variance
        double idealMean = (Math.pow(10, 8) - 1) / 2.0; // Ideal mean for [0, 8] (8 digits)
        double idealVariance = ((Math.pow(10, 8) + 1) * (Math.pow(10, 8) - 1)) / 12.0; // Ideal variance for [0, 8] (8 digits)


        System.out.println("SplittableRandom Mean: " + mean);
        System.out.println("SplittableRandom Variance: " + variance);

        System.out.println("SplittableRandom idealMean: " + idealMean);
        System.out.println("SplittableRandom idealVariance: " + idealVariance);
    }
}
