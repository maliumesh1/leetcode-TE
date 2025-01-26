class Solution {
    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // Step 1: Initialize arrays
        int[] ins = new int[n]; // Array to store in-degrees
        int[] queue = new int[n]; // Queue for topological sorting
        int[] deep = new int[n]; // Depth array to store chain lengths

        // Step 2: Count in-degrees
        for (int i = 0; i < n; i++) {
            ins[favorite[i]]++;
        }

        // Step 3: Process chains using topological sorting
        int l = 0, r = 0; // Pointers for the queue
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0)
                queue[r++] = i; // Add nodes with in-degree 0
        }

        while (l < r) {
            int cur = queue[l++]; // Remove node from queue
            int next = favorite[cur]; // Follow the edge to the next node
            deep[next] = Math.max(deep[next], deep[cur] + 1); // Update chain length
            if (--ins[next] == 0) { // Reduce in-degree of the next node
                queue[r++] = next;
            }
        }

        // Step 4: Process cycles and calculate results
        int smallCircle = 0; // Sum of lengths of chains and 2-cycles
        int bigCircle = 0; // Maximum cycle length for larger cycles

        for (int i = 0; i < n; i++) {
            if (ins[i] != 0) { // Node is part of a cycle
                ins[i] = 0; // Mark node as visited
                int count = 1; // Count the cycle size
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    count++;
                    ins[j] = 0; // Mark all nodes in the cycle as visited
                }

                if (count == 2) { // Special case: 2-cycle
                    smallCircle += deep[i] + deep[favorite[i]] + 2;
                } else { // Larger cycles
                    bigCircle = Math.max(bigCircle, count);
                }
            }
        }

        return Math.max(bigCircle, smallCircle); // Return the maximum result

    }
}