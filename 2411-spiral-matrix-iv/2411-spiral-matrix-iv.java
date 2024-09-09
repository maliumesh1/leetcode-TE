class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int table[][] = new int[m][];
        for (int i = 0; i != m; i++)
            table[i] = new int[n];

        int l = 0, r = n, t = 0, b = m;

        while (l < r && t < b) {
            for (int i = l; i < r; i++)
                if (head != null) {
                    table[t][i] = head.val;
                    head = head.next;
                } else
                    table[t][i] = -1;
            t++;
            if (t == b)
                break;
            for (int i = t; i < b; i++)
                if (head != null) {
                    table[i][r - 1] = head.val;
                    head = head.next;
                } else
                    table[i][r - 1] = -1;
            r--;
            if (l == r)
                break;
            for (int i = r - 1; i >= l; i--)
                if (head != null) {
                    table[b - 1][i] = head.val;
                    head = head.next;
                } else
                    table[b - 1][i] = -1;
            b--;
            if (t == b)
                break;
            for (int i = b - 1; i >= t; i--)
                if (head != null) {
                    table[i][l] = head.val;
                    head = head.next;
                } else
                    table[i][l] = -1;
            l++;
        }

        return table;
    }

}