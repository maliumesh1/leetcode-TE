class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0, ans = 0;
        
        for(int i : nums) {
            freq[i]++;

            if(freq[i]>max) {
                max = freq[i];
                ans = 0;
            }

            if(freq[i] == max) ans+=max;
        }        
        
        return ans;
    }
}