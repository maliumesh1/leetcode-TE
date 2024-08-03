class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;
        int a[] = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
            a[target[i]]--;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != 0)
                return false;
        return true;
    }

}