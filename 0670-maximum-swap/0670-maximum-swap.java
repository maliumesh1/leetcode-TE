class Solution {
    public int maximumSwap(int num) {
        int x = num;
        int delta = 0;
        int hi = x % 10, multiple = 1, prev = 1;
        x /= 10;
        while (x > 0) {
            multiple *= 10;
            if (x % 10 > hi) {
                hi = x % 10;
                prev = multiple;
            } else if (x % 10 < hi) {
                delta = (hi - x % 10) * multiple - (hi - x % 10) * prev;
            }
            x /= 10;
        }
        return num + delta;
    }

}