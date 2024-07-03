class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
                int N = Math.min(nums1.length, nums2.length);
                        int[] mp = new int[1001];
                                int[] ans = new int[N];
                                        for(int num : nums1) mp[num]++;
                                                int k = 0;
                                                        for(int num : nums2) if(mp[num]-->0) ans[k++] = num;
                                                                return Arrays.copyOfRange(ans, 0, k);
                                                                    }
                                                                    
}