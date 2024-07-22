class Solution {
    public void quicksort(int low, int high, String[] names, int[] heights) {
        if (low >= high)
            return;
        int i = low;
        int j = high;
        int mid = low + (high - low) / 2;
        int pivot = heights[mid];
        while (i <= j) {
            while (heights[i] > pivot)
                i++;
            while (heights[j] < pivot)
                j--;
            if (i <= j) {
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;
                String s = names[i];
                names[i] = names[j];
                names[j] = s;
                i++;
                j--;
            }
        }
        quicksort(low, j, names, heights);
        quicksort(i, high, names, heights);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        quicksort(0, heights.length - 1, names, heights);
        return names;
    }

}