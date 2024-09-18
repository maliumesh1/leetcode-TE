class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // convert the integer array to string array
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) {
            return "0";

        }
        StringBuilder result = new StringBuilder();
        for (String num : arr) {
            result.append(num);
        }
        return result.toString();
    }

}