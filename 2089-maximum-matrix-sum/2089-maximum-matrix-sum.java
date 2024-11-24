class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int numNegatives = 0;
        long totalSum = 0;
        int minNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int e = 0; e < matrix[0].length; e++) {
                int value = matrix[i][e];
                if (value < 0) {
                    numNegatives++;
                    totalSum = totalSum - value;
                    minNeg = value > minNeg ? value : minNeg;
                } else {
                    totalSum = totalSum + value;
                    minPos = value < minPos ? value : minPos;
                }
            }
        }

        int min = Math.min(minPos, -minNeg);

        return totalSum - numNegatives % 2 * (min + min);
    }

}