package sample.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;


public class HammingAlgorithmTest {
    private final String tenDigitMsg = "0111001100";
    private final int[] expectedTenDigitsRedMsg = {1,1,1,0,0,1,1,1,0,0,0,1,1,0,0};

    @Test
    public void calculationOfNoRedundantBitsIsCorrect() {
        // Given length of msg and expected number of redundant bits
        final int length = 10;
        final int expectedNoRedundantBits = 5;

        // When performing calculation of noRedundantBits
        final int noRedundantBits = HammingAlgorithm.calculateNoRedundantBits(length);

        // Then check if noRedundantBits is as expected
        assertThat(noRedundantBits).isEqualTo(expectedNoRedundantBits);
    }

    @Test
    public void transformationIntoRedundantMsgIsCorrect() {
        // Given
        final int M = tenDigitMsg.length();
        final int r = HammingAlgorithm.calculateNoRedundantBits(M);
        final int[] expectedMsg = {0,0,0,0,0,1,1,1,0,0,0,1,1,0,0};

        // When
        int[] redundantMsg = HammingAlgorithm.generateRedundantMessage(tenDigitMsg, M, r);

        // Then
        assertThat(redundantMsg).isEqualTo(expectedMsg);
    }


    @Test
    public void calculationOnWholeRedundantMsgIsCorrect() {
        // When
        int[] transformedMsg = HammingAlgorithm.calculate(tenDigitMsg);

        // Then
        assertThat(transformedMsg).isEqualTo(expectedTenDigitsRedMsg);
    }

    @Test
    public void calculationOnFourDigitMsgIsCorrect() {
        // Given clean msg
        final String msg = "1000";
        final int[] expectedMsg = {1,1,1,1,0,0,0,0};

        // When
        int[] transformedMsg = HammingAlgorithm.calculate(msg);

        // Then
        assertThat(transformedMsg).isEqualTo(expectedMsg);
    }

    @Test
    public void calculationOnElevenDigitMsgIsCorrect() {
        // Given a clean msg
        final String msg = "00110001110";
        final int[] expectedMsg = {0,0,1,0, 1,0,1,1, 1,0,0,0, 1,1,1,0};

        // When
        int[] transformedMsg = HammingAlgorithm.calculate(msg);

        // Then
        assertThat(transformedMsg).isEqualTo(expectedMsg);
    }

    @Test
    public void testSingleErrorDetecting() {
        // Given a msg with error on 10th position
        final int[] msgWithError = {0,0,1,0, 1,0,1,1, 1,0,1,0, 1,1,1,0};
        final int expectedErrorIndex = 10;

        // When executing error detection
        final int errorIndex = HammingAlgorithm.calculateErrorIndex(msgWithError);

        // Then check if errorIndex is as expected
        assertThat(errorIndex).isEqualTo(expectedErrorIndex);
    }

    @Test
    public void testDoubleErrorDetecting() {
        // Given a msg with error on 10th position
        final int[] msgWithError = {0,0,1,0, 1,0,1,1, 1,0,1,1, 1,1,1,0};
        final int expectedErrorIndex = -1;

        // When executing error detection
        final int errorIndex = HammingAlgorithm.calculateErrorIndex(msgWithError);

        // Then check if errorIndex is as expected
        assertThat(errorIndex).isEqualTo(expectedErrorIndex);
    }
}