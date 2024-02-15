
class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            pq.offer(num);
        }
        
        while (pq.size() > 2) {
            int num = pq.poll();
            if (sum > 2 * num) {
                return sum;
            }
            sum -= num;
        }
        
        return -1;
    }
}