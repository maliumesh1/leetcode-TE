class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int tot = a + b + c;
        int ca = 0, cb = 0, cc = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tot; i++) {
            if ((a >= b && a >= c && ca < 2) || (cb == 2 && a > 0 && ca < 2) || (cc == 2 && a > 0 && ca < 2)) {
                sb.append("a");
                a--;
                ca++;
                cb = 0;
                cc = 0;
            } else if ((b >= a && b >= c && cb < 2) || (ca == 2 && b > 0 && cb < 2) || (cc == 2 && b > 0 && cb < 2)) {
                sb.append("b");
                b--;
                cb++;
                ca = 0;
                cc = 0;
            } else if ((c >= a && c >= b && cc < 2) || (ca == 2 && c > 0 && cc < 2) || (cb == 2 && c > 0 && cc < 2)) {
                sb.append("c");
                c--;
                cc++;
                ca = 0;
                cb = 0;
            }
        }
        return sb.toString();
    }

}