
class Solution {
    public String largestNumber(int[] nums) {
        // Convert integer array to string array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the strings using a custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join the sorted strings to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String str : strNums) {
            largestNumber.append(str);
        }

        return largestNumber.toString();
    }
}
