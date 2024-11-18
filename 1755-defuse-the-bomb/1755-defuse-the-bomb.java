class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        int left = 0;
        int right = 0;

        // sum of sliding window
        int sum = 0;

        // guard clause
        if (k == 0) {
            return res;
        }

        // setting the left and right pointers depending on +k or -k
        if (k > 0) {
            left = 0;
            right = k;
        }
        if (k < 0) {
            left = code.length - (1 + Math.abs(k));
            right = code.length - 1;
        }

        // initializing the sliding window - note the +1 because we don't actually want
        // the value itself. i.e. if updating index 0 we don't want to include code[0]
        // as part of the sum. We want code[1] to code[3]
        for (int i = left + 1; i < (right + 1); i++) {
            sum += code[i];
        }

        int i = 0;
        // since our sliding window sum is already set up, we have to change the order
        // we do things while iterating. i.e. sum first calculate for next loop later.
        // probably could be written using a for loop but i just wanted a working
        // solution
        while (i < code.length) {
            res[i] = sum;
            i++;
            sum -= code[(left + i) % code.length];
            sum += code[(right + i) % code.length];
        }

        return res;
    }

}