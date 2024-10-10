class Solution {
    public int maxWidthRamp(int[] a) {
        int[] arr = new int[a.length];
        arr[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            arr[i] = Math.max(arr[i + 1], a[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            a[i] = Math.min(a[i - 1], a[i]);
        }
        /*
         * for(int i=0;i<arr.length;i++){
         * System.out.print(arr[i]+"  ");
         * }
         * System.out.println();
         * for(int i=0;i<arr.length;i++){
         * System.out.print(a[i]+"  ");
         * }
         */
        int ans = 0;
        // System.out.println();
        for (int i = 0; i < a.length - ans - 1; i++) {
            if (a[i] > arr[i + 1 + ans]) {
                continue;
            }
            int index = bs(arr.length - 1, i + ans + 1, arr, a[i]);
            // System.out.println(arr[index]+" " +i+" " +index);
            ans = index - i;

        }
        return ans;
    }

    public int bs(int l, int h, int[] arr, int key) {
        if (h == l) {
            return l;
        }
        int mid = h + (l - h + 1) / 2;
        if (arr[mid] >= key) {
            return bs(l, mid, arr, key);
        } else {
            return bs(mid - 1, h, arr, key);
        }
    }

}