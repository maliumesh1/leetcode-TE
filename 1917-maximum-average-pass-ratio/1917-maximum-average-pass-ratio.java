class Solution {
    class Node {
        int index;
        double inc;

        public Node(int index, double inc) {
            this.index = index;
            this.inc = inc;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.inc > a.inc ? 1 : b.inc < a.inc ? -1 : 0);
        for (int i = 0; i < classes.length; i++) {
            updateHeap(i, classes, pq);
        }
        while (extraStudents-- > 0) {
            Node curr = pq.remove();
            classes[curr.index][0]++;
            classes[curr.index][1]++;
            updateHeap(curr.index, classes, pq);
        }
        double sum = 0.0;
        for (int[] c : classes) {
            sum += (double) c[0] / c[1];
        }
        return sum / classes.length;
    }

    public void updateHeap(int index, int[][] classes, PriorityQueue<Node> pq) {
        double currRatio = (double) classes[index][0] / classes[index][1];
        double newRatio = (double) (classes[index][0] + 1) / (classes[index][1] + 1);
        pq.add(new Node(index, newRatio - currRatio));
    }

}