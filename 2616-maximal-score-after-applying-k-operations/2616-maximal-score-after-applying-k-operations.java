class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            hp.add(num);
        }

        long res = 0;
        while (k-- > 0) {
            int ma = hp.poll();
            res += ma;
            hp.add((ma + 2) / 3);
        }
        return res;
    }

}