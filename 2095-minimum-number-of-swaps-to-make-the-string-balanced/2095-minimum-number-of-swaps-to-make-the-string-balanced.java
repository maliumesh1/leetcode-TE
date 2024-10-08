class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;
        int minSwap = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[')
                open++;
            else {
                if (open > 0)
                    open--;
                else
                    close++;
            }
        }
        int total = open + close;
        if (total == 0) {
            return 0;
        }

        if (total > 4) {
            minSwap = total / 4;
            total = total % 4;
        }
        if (total != 0) {
            minSwap++;
        }
        return minSwap;
    }

}