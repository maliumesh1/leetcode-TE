import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int l) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max heap
        int n = heights.length;
        int i;
        for (i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                if (bricks >= diff) {
                    bricks -= diff;
                    pq.offer(diff);
                } else if (l > 0) {
                    if (!pq.isEmpty() && pq.peek() > diff) {
                        int top = pq.poll();
                        bricks += top - diff;
                        pq.offer(diff);
                        l--;
                    } else {
                        l--;
                    }
                } else {
                    break;
                }
            }
        }
        return i;
    }
}