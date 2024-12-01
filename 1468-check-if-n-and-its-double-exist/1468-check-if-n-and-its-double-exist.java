
class Solution {
    public boolean checkIfExist(int[] arr) {
        int[] pos = new int[2001];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            pos[arr[i] + 1000]++;
        }
        for (int i = -500; i < 0; i++) {
            if (pos[i + 1000] > 0 && pos[2 * i + 1000] > 0)
                return true;
        }
        for (int i = 1; i <= 500; i++) {
            if (pos[i + 1000] > 0 && pos[2 * i + 1000] > 0)
                return true;
        }
        if (pos[1000] > 1)
            return true;
        return false;
    }
}