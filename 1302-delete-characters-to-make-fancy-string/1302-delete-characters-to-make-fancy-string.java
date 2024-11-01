class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < 3)
            return s;
        StringBuilder res = new StringBuilder();
        int i = 1;
        int prev = 0;
        char c;
        while (i < n) {
            if (arr[i] != arr[prev]) {
                c = arr[prev];
                if (i - prev >= 2) {
                    res.append(c).append(c);
                } else {
                    res.append(c);
                }
                prev = i;
            }
            i++;
        }
        c = arr[prev];
        if (i - prev >= 2) {
            res = res.append(c).append(c);
        } else {
            res = res.append(c);
        }

        return res.toString();
    }

}