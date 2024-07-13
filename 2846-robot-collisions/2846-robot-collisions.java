class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on positions
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] eliminated = new boolean[n];

        for (int index : indices) {
            if (directions.charAt(index) == 'L') {
                while (!stack.isEmpty() && !eliminated[index]) {
                    int top = stack.peek();
                    if (healths[index] < healths[top]) {
                        eliminated[index] = true;
                        healths[top]--;
                    } else if (healths[index] > healths[top]) {
                        stack.pop();
                        eliminated[top] = true;
                        healths[index]--;
                    } else {
                        stack.pop();
                        eliminated[top] = true;
                        eliminated[index] = true;
                        break;
                    }
                }
            } else {
                stack.push(index);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!eliminated[i]) {
                result.add(healths[i]);
            }
        }
        return result;
    }

}