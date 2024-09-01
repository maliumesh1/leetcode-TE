class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][];
        if (n * m < original.length || n * m > original.length)
            return new int[][] {};
        if (m > original.length && n >= original.length)
            return new int[][] {};
        if (m <= original.length && n > original.length)
            return new int[][] {};
        int count = 0;
        for (int i = 0; i < original.length; i = i + n) {
            arr[count++] = Arrays.copyOfRange(original, i, i + n);
        }
        return arr;
    }

}