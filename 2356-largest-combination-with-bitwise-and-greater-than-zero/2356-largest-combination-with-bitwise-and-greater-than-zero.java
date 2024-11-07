class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[100];
        int largest = 0;
        for (int candidate : candidates) {
            int curNum = candidate, count = 0;
            while (curNum > 0) {
                bitCount[count++] += (curNum & 1);
                curNum >>= 1;
            }
        }

        for (int i = 0; i < 100; i++) {
            largest = Math.max(largest, bitCount[i]);
        }
        return largest;
    }

}