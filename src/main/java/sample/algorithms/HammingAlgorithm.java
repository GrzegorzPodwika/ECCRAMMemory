package sample.algorithms;

import java.util.Arrays;

public class HammingAlgorithm {

    private HammingAlgorithm() {
    }

    public static int[] calculate(String message) {
        final int M = message.length();
        final int r = calculateNoRedundantBits(M);

        int[] redundantMessage = generateRedundantMessage(message, M, r);

        return calculateRedundantFactors(redundantMessage, r);
    }

    static int calculateNoRedundantBits(final int msgLength) {
        int r = 1;

        while (Math.pow(2, r) < (msgLength + r + 1))
            r++;

        // last increment of r to add zero parity bit
        r++;

        return r;
    }

    static int[] generateRedundantMessage(String message, int M, int r) {
        int[] redundantMessage = new int[M + r];
        int j = 0;

        for (int i = 0; i < redundantMessage.length; i++) {
            // logical bitwise AND of its operands checks if i is a power of 2
            if ((i & (i - 1)) == 0) {
                redundantMessage[i] = 0;

            } else {
                redundantMessage[i] = (int) (message.charAt(j) - '0');
                j++;
            }
        }

        return redundantMessage;
    }

    static int[] calculateRedundantFactors(int[] redundantMessage, int r) {
        for (int i = 0; i < r; i++) {
            int p = (int) Math.pow(2, i);
            for (int j = 1; j < redundantMessage.length; j++) {
                if (((j >> i) & 1) == 1) {
                    if (p != j)
                        redundantMessage[p] = redundantMessage[p] ^ redundantMessage[j];
                }
            }
        }


        for (int i = 1; i < redundantMessage.length; i++) {
            redundantMessage[0] = redundantMessage[0] ^ redundantMessage[i];
        }

        return redundantMessage;
    }

    public static int calculateErrorIndex(int[] redundantMessage) {
        int index = 0;
        int parityBit = 0;

        for (int i = 0; i < redundantMessage.length; i++) {
            if (redundantMessage[i] == 1) {
                index = index ^ i;
                parityBit = parityBit ^ 1;
            }
        }

        // two errors have been detected
        if (parityBit == 0 && index != 0) {
            return ResponseCode.TWO_ERRORS.code;
        } else if(parityBit == 0 && index == 0) {
            // no errors have been detected
            return ResponseCode.NO_ERRORS.code;
        } else {
            // one error has been detected
            // more than two errors have been detected
            return index;
        }
    }

}
