class Solution {
    public String compressedString(String word) {
        // Create StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder();

        // count: tracks number of consecutive characters
        // j: used for inner loop to count consecutive characters
        int count = 0, j = 0;

        // Iterate through each character in the word
        for (int i = 0; i < word.length(); ++i) {
            // Set j to current position
            j = i;

            // Get current character to compare
            char c = word.charAt(i);

            // Count consecutive occurrences of current character
            while (j < word.length() && word.charAt(j) == c) {
                ++count;
                ++j;
            }

            // Handle cases where count exceeds 9
            // Break it into multiple groups of 9
            while (count > 9) {
                sb.append('9'); // Add count of 9
                sb.append(c); // Add character
                count -= 9; // Reduce remaining count by 9
            }

            // Append remaining count (1-9) and character
            sb.append((char) (count + '0')); // Convert count to character
            sb.append(c); // Add character

            // Reset count for next character
            count = 0;

            // Update outer loop counter
            // Subtract 1 because loop will increment i
            i = j - 1;
        }

        // Return compressed string
        return sb.toString();
    }

}