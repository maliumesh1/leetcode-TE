class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        // Greedily:
        // find the maximum element between all arrays
        // find the minimum element between all arrays
        // if the index of max and min are different return that difference
        // Otherwise, find the indices with an alternative min and max

        int numArrays = arrays.size();
        int max = -1000000;
        int min = 1000000;
        int indexWithMax = -1;
        int indexWithMin = -1;
        for (int i = 0; i < numArrays; i++) {

            List<Integer> array = arrays.get(i);
            if (array.get(0) < min) {

                min = array.get(0);
                indexWithMin = i;

            }
            if (array.get(array.size() - 1) > max) {

                max = array.get(array.size() - 1);
                indexWithMax = i;

            }

        }

        if (indexWithMax != indexWithMin)
            return max - min;

        int otherMax = -1000000;
        int otherMin = 1000000;
        for (int i = 0; i < numArrays; i++) {

            if (i == indexWithMin)
                continue;
            List<Integer> array = arrays.get(i);
            if (array.get(array.size() - 1) > otherMax) {

                otherMax = array.get(array.size() - 1);

            }
            if (array.get(0) < otherMin) {

                otherMin = array.get(0);

            }

        }

        return Math.max(max - otherMin, otherMax - min);

    }

}