class Solution {
        public int minDifference(int[] nums) {
                
                        // if the size is smaller than 4 than we can easily make each of them equal and hence min possible difference is zero
                                if(nums.length <= 3) return 0;
                                        
                                                int n = nums.length;
                                                        
                                                                // sort the array in increasing order because we want to consider few of the largest and smallest numbers.
                                                                        Arrays.sort(nums);
                                                                                
                                                                                        int res = Integer.MAX_VALUE; // initialize the result with INT_MAX.
                                                                                                
                                                                                                        
                                                                                                                // Now idea is to try greedy. First of all we must agree that the values 
                                                                                                                		// which we will be changing should be either from left end or right end, 
                                                                                                                        		// As there is no gain if we start changing values from middle of the array. 
                                                                                                                                		// And hence we can try to make these 3 moves in all following possible 
                                                                                                                                        		// ways and choose the one which gives the best answer. 
                                                                                                                                                        // And because there are only 3 moves so total possibilities will be exactly 4.
                                                                                                                                                                
                                                                                                                                                                        
                                                                                                                                                                                // CASE 1: when changing only from beg
                                                                                                                                                                                        res = Math.min(res, Math.abs(nums[3] - nums[n - 1]));
                                                                                                                                                                                                
                                                                                                                                                                                                        // CASE 2: when change two from beg and one from last
                                                                                                                                                                                                                res = Math.min(res, Math.abs(nums[2] - nums[n - 2]));
                                                                                                                                                                                                                        
                                                                                                                                                                                                                                // CASE 3: when change only from beg and two from last
                                                                                                                                                                                                                                        res = Math.min(res, Math.abs(nums[1] - nums[n - 3]));
                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                        // CASE 4: when change all the values from last
                                                                                                                                                                                                                                                                res = Math.min(res, Math.abs(nums[0] - nums[n - 4]));
                                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                                return res;
                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    // Time Complexity :- O(NlogN)
                                                                                                                                                                                                                                                                                    // Space Complexity :- O(1)
}