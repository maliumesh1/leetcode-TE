class Solution {
    public char[][] rotateTheBox(char[][] box) {
        final int m = box.length, n = box[0].length;
        final char[][] res = new char[n][m];

        for (int i = 0; i < m; ++i) {
            for (int j = n - 1, p = n - 1; j >= 0; --j) {
                res[j][m - i - 1] = '.';

                if (box[i][j] != '.') {
                    p = box[i][j] == '*' ? j : p;
                    res[p--][m - i - 1] = box[i][j];
                }
            }
        }

        return res;
    }

}