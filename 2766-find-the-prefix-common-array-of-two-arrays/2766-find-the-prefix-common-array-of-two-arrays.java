class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int count = 0;
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, false);
        for (int i = 0; i < n; i++) {
            if (arr[A[i]])
                count++;
            arr[A[i]] = true;
            if (arr[B[i]])
                count++;
            arr[B[i]] = true;
            C[i] = count;
        }
        return C;
    }

}