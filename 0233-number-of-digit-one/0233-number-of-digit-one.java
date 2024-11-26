class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long place = 1; // Start with units place
        
        while (place <= n) {
            long left = n / (place * 10);   // Higher digits
            long current = (n / place) % 10; // Current digit
            long right = n % place;         // Lower digits
            
            // Count ones contributed by current digit
            if (current == 0) {
                count += left * place;
            } else if (current == 1) {
                count += left * place + (right + 1);
            } else {
                count += (left + 1) * place;
            }
            
            // Move to the next place (units -> tens -> hundreds, etc.)
            place *= 10;
        }
        
        return count;
    }
}
