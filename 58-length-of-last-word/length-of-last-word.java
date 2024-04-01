class Solution {
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        String x = a[a.length -1];
        return x.length();
    }
}