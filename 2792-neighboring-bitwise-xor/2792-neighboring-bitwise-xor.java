class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorVal = 0;
        for (int ele : derived)
            xorVal ^= ele;
        return (xorVal == 0);
    }

}