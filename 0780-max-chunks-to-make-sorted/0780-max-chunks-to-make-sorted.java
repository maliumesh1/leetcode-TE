class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxchunk = 0;
        for (int i = 0; i < arr.length; i++) {
            maxchunk = Math.max(arr[i], maxchunk);
            if (maxchunk == i)
                chunks++;
        }
        return chunks;
    }

}