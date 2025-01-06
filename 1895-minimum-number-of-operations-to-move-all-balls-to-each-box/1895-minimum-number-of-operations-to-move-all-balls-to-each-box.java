class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int ans[] = new int[n];
        int right[] = new int[n];
        int left[] = new int[n];

        int c = boxes.charAt(0) - '0'; // 001011 c=0
        for (int i = 1; i < n; i++) {
            left[i] = c + left[i - 1]; // previosidx +curr eg. [0,0,0,1,2,4]
            c += boxes.charAt(i) - '0'; // this return value of boxes[i] --->0,1 //and add value to c whenever 1
                                        // encounter
        }

        c = boxes.charAt(n - 1) - '0'; // c=1
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + c; // O/P : [11,8,5,3,1,0]
            c += boxes.charAt(i) - '0';
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }

}