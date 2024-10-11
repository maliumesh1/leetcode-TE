class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> pQ1 = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pQ2 = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pQ3 = new PriorityQueue<Integer>();
        for (int i = 0; i < times.length; i++) {
            pQ1.offer(new int[] { times[i][0], times[i][1], i });
        }
        int next = 0;
        while (!pQ1.isEmpty()) {
            int[] tuple = pQ1.poll();
            int seat = next;
            while (!pQ2.isEmpty() && pQ2.peek()[0] <= tuple[0]) {
                int[] pair = pQ2.poll();
                pQ3.offer(pair[1]);
            }
            if (!pQ3.isEmpty()) {
                seat = pQ3.poll();
            } else {
                next++;
            }
            if (tuple[2] == targetFriend) {
                return seat;
            }
            pQ2.offer(new int[] { tuple[1], seat });
        }
        return -1;
    }

}