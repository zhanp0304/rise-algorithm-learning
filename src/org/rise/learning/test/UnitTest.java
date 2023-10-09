package org.rise.learning.test;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Description
 *
 * @author zhanpeng.jiang@hand-china.com 2023/10/9
 */
public class UnitTest {
    @Test
    public void testRandomnessWithChiSquaredTest() {
        CustomThreadLocalRandom randomGenerator = CustomThreadLocalRandom.current();
        int sampleSize = 10000; // Adjust the sample size as needed
        int numValues = 100_000_000;     // Adjust the number of possible values as needed
        List<Integer> observedFrequencies = new ArrayList<>();

        // Generate random numbers and record their frequencies
        for (int i = 0; i < numValues; i++) {
            observedFrequencies.add(0);
        }

        for (int i = 0; i < sampleSize; i++) {
            int randomNumber = randomGenerator.nextInt(8); // Adjust the range as needed
            observedFrequencies.set(randomNumber, observedFrequencies.get(randomNumber) + 1);
        }

        // Perform a Chi-Squared Test
        double chiSquareStatistic = 0.0;
        double[] expectedFrequencies = new double[numValues];
        for (int i = 0; i < numValues; i++) {
            expectedFrequencies[i] = (double) sampleSize / numValues;
            chiSquareStatistic += Math.pow(observedFrequencies.get(i) - expectedFrequencies[i], 2) / expectedFrequencies[i];
        }

        // Calculate the degrees of freedom
        int degreesOfFreedom = numValues - 1;

        // Set the significance level for the test
        double significanceLevel = 0.05;

        // Use the chi-square distribution to find the critical value
        ChiSquaredDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);
        double criticalValue = chiSquaredDistribution.inverseCumulativeProbability(1.0 - significanceLevel);

        // Assert that the test passes (chi-square statistic < critical value)
        assertTrue(chiSquareStatistic < criticalValue);
    }
}
