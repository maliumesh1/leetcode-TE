class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int a = 0;
        int b = 0;
        int max = 0;
        if (x > y) {
            for (int i = 0; i < n; i++) {
                switch (chars[i]) {
                    case 'a':
                        a++;
                        break;
                    case 'b':
                        if (a > 0) {
                            a--;
                            max += x;
                        } else
                            b++;
                        break;
                    default:
                        max += Math.min(a, b) * y;
                        a = 0;
                        b = 0;
                }
            }
            max += Math.min(a, b) * y;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                switch (chars[i]) {
                    case 'a':
                        a++;
                        break;
                    case 'b':
                        if (a > 0) {
                            a--;
                            max += y;
                        } else
                            b++;
                        break;
                    default:
                        max += Math.min(a, b) * x;
                        a = 0;
                        b = 0;
                }
            }
            max += Math.min(a, b) * x;
        }
        return max;

    }
}