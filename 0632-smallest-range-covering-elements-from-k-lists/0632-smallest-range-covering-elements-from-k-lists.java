class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int ma = Integer.MIN_VALUE;
        int k = nums.size();
        int[] res = { -100000, 100000 };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[] { val, 0, i });
            ma = Math.max(ma, val);
        }

        while (true) {
            int[] mi = pq.poll();
            int val = mi[0], idx = mi[1], listIdx = mi[2];

            if (res[1] - res[0] > ma - val) {
                res[0] = val;
                res[1] = ma;
            }

            if (idx + 1 == nums.get(listIdx).size())
                break;

            int nextVal = nums.get(listIdx).get(idx + 1);
            ma = Math.max(ma, nextVal);
            pq.offer(new int[] { nextVal, idx + 1, listIdx });
        }

        return res;
    }

}