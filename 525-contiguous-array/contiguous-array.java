/*
    Change 0 in the original array to -1 so we can use -1 as part of our rolling sum.
    0 cannot be used in addition or subtraction
    If WE hit 0 early on and 0 at the end, that means all numbers in between sum up to zero
    (which means we have equal number of 0 and 1 in the array)
    Time: O(n)
*/
class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // Change 0 in the original array to -1 
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>(); // <cumulative sum, index>
        int sum = 0;
        int max = 0;
        map.put(0, -1); // need -1 index so we can calculate the difference properly with the 0 index
        
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i]; // add rolling sum 
            /*
             // if at any time we reach the sum again (-2, -1, -, 1, 2)
             For example, we can hit 0 multiple times in our rolling sum and we always take longest subarray starting from oldest point of sum 0 to current index
            */
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max, i - last); // calcualte diff between curr index and earliest 0 sum
            } else { // otherwise we put new sum at new earliest index that we encounter it
                map.put(sum, i);
            }
        }
        
        return max;
        
    }
}