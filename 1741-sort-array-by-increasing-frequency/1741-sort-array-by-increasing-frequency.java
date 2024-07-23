class Solution {
    public int[] frequencySort(int[] nums) {
        int[] bucket = new int[201]; // 201 because all numbers are between -100 to 100
        // store the frequency of numbers in bucket array
        // we will store it in such a way that it can handle the case of "if frequency
        // of two elements are same, then place them in decreasing order"
        // so occurrences of max number 100 will be at index 0 and of min num -201 at
        // index 200 of bucket array
        for (int a : nums) {
            if (a >= 0)
                bucket[100 - a]++; // +ve numbers at 0 to 100 index (in decreasing order of 100 to 0)
            if (a < 0)
                bucket[100 + Math.abs(a)]++; // -ve numbers at index 101 to 200 (-1 to -100)
        }

        // below code snippet basically finds all numbers of freq 1 and places it, then
        // 2 freq numbers, and so on until
        // we find all the elements
        // since we have already extracted the data from original array nums, we can now
        // modify it to our answer array
        int index = 0; // pointer to place items
        int freq = 1; // starting frequency
        while (index < nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == freq) {
                    while (bucket[i] != 0) { // while loop is so that if freq is 4 then element has to be placed 4 times
                        nums[index++] = 100 - i;
                        bucket[i]--;
                    }
                }
            }
            freq++;
        }
        return nums;
    }

}