
class Solution {
    public int takeCharacters(String s, int k) {
        // Frequency array to count occurrences of 'a', 'b', and 'c'
        int[] arr = new int[3];

        // Count initial frequency of 'a', 'b', and 'c' in the string
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        // If any character ('a', 'b', or 'c') is less than k, it's impossible to
        // fulfill the requirement
        if (arr[0] < k || arr[1] < k || arr[2] < k) {
            return -1;
        }

        // Initialize the minimum answer to the full length of the string
        int ans = arr[0] + arr[1] + arr[2];
        int st = 0; // Start index of the sliding window

        // Iterate through the string with the sliding window
        for (char ch : s.toCharArray()) {
            // Decrease the count of the current character
            arr[ch - 'a']--;

            // Check if we can satisfy the condition of having at least 'k' of each
            // character
            if (arr[0] < k || arr[1] < k || arr[2] < k) {
                // If we can't, update the answer and attempt to shrink the window
                ans = Math.min(arr[0] + arr[1] + arr[2] + 1, ans);

                // Shrink the window from the left
                while (s.charAt(st) != ch) {
                    arr[s.charAt(st) - 'a']++;
                    st++;
                }
                arr[ch - 'a']++; // Restore the count of the current character
                st++; // Move the start of the window forward
            }
        }

        // Final check for the smallest number of deletions needed
        ans = Math.min(arr[0] + arr[1] + arr[2], ans);

        return ans;
    }
}