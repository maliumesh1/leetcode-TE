class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int ma = 0;
        int[] res = new int[queries.length];
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int[] i : items) {
            if (ma < i[1]) {
                ma = i[1];
                mp.put(i[0], ma);
            }
        }

        for (int i = 0; i < res.length; i++) {
            Integer key = mp.floorKey(queries[i]);
            res[i] = (key == null) ? 0 : mp.get(key);
        }

        return res;
    }

}