class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int a[] = new int[arr.length];
        HashMap<Integer, Integer> h = new HashMap<>();
        int l = 1;
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (!h.containsKey(a[i])) {
                h.put(a[i], l);
                l++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            a[i] = h.get(arr[i]);
        }
        return a;
    }

}