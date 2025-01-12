class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1)
            return false;

        int totalOpen = 0, open = 0;
        int closed = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    totalOpen++;
                    open++;
                } else {
                    if (totalOpen > 0) {
                        if (open == 0)
                            count++;
                        else
                            open--;
                        totalOpen--;
                    } else if (count > 0) {
                        count--;
                    } else
                        return false;
                }
            } else {
                if (open > 0)
                    open--;
                else
                    count++;
            }
        }
        if (open > 0)
            return false;
        return true;
    }

}