class Solution {
    public int reverse(int x) {
        int temp = x; // Initialize a temporary variable to store the input integer
        long rev = 0; // Initialize a long variable to store the reversed integer. Use long to handle potential overflow cases.

        while (temp != 0) { // Iterate through the digits of the input integer
            rev = rev * 10 + temp % 10; // Extract the last digit of temp and add it to rev after multiplying rev by 10
            temp = temp / 10; // Update temp by dividing it by 10
        }
        
        if (rev == (int) rev) { // Check if the reversed integer fits within the range of a 32-bit signed integer
            return (int) rev; // If it does, return it as an integer
        } else {
            return 0; // Otherwise, return 0 to indicate overflow
        }
    }
}