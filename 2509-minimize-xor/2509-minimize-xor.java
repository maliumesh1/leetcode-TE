class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num1);
        int k = Integer.bitCount(num2);
        int result = num1;
        if (count == k)
            return result;
        else if (count > k) {
            for (int i = 0; count > k && i < 32; i++) {
                if ((result & (1 << i)) != 0) { // If bit i is set
                    result &= ~(1 << i); // Turn off bit i
                    count--;
                }
            }
        } else {
            for (int i = 0; count < k && i < 32; i++) {
                if ((result & (1 << i)) == 0) { // If bit i is unset
                    result |= (1 << i); // Turn on bit i
                    count++;
                }
            }
        }

        return result;

    }

}