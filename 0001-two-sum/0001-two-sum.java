class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n=nums.length;
                for(int i=1;i<n;i++){
                        for(int j=i;j<n;j++){
                                    if(target==nums[j-i]+nums[j])
                                                    return new int[]{j-i,j};
                                                            }
                                                                }   
                                                                    return new int[2];
                                                            
                                                                        }
}