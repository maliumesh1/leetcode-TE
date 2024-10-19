class Solution {
    // TC: O(logn) where n is length of nth string - because we search if half
    // string length each time
    // SC: O(1) as we use constant space of 20 integers
    public char findKthBit(int n, int k) {
        // first lets save the length of n strings for later use
        int[] len = new int[n];
        len[0] = 1;
        for (int i = 1; i < n; i++) {
            len[i] = 2 * len[i - 1] + 1;
        }
        // then call a helper function using this memoized array
        return kthBitHelper(len, n, k);
    }

    private char kthBitHelper(int[] len, int n, int k) {
        // base condition
        if (n == 1) {
            return '0';
        }
        // calculate the half length - this is equal to the length of previous string
        int halfLength = len[n - 1] / 2;
        // if the k position is middle of string then just return '1'
        if (k == (halfLength + 1)) {
            return '1';
        } else if (k <= halfLength) { // if its less than middle position, then it should have same position as the
                                      // previous string
            return kthBitHelper(len, n - 1, k);
        }
        // if its grater than middle position, then it should be the flp of character
        // from the reversed string of previous string
        char prev = kthBitHelper(len, n - 1, halfLength - (k - halfLength - 1) + 1);
        return prev == '0' ? '1' : '0';
    }

}