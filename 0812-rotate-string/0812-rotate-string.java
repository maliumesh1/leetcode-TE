class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        int possibleRotation = s.length() - 1;

        StringBuilder str = new StringBuilder();
        while (possibleRotation > 0) {
            possibleRotation--;
            str.append(s.substring(1, s.length()));
            str.append(s.charAt(0));
            if (str.toString().equals(goal)) {
                return true;
            }
            s = str.toString();
            str = new StringBuilder();
        }

        return false;
    }

}
