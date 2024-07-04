class Solution {
        public int searchInsert(int[] nums, int target) {
                int l = nums.length;
                        if ( target<=nums[0] ) return 0;
                                if ( target>nums[l-1] ) return l;
                                        int left=0; 
                                                int right=l;
                                                        int mid;
                                                                while (true) {
                                                                            mid = (left+right)/2;
                                                                                        if (target>nums[mid] && target<nums[mid+1]) return mid+1;
                                                                                                    else if (target==nums[mid] && target>nums[mid-1]) return mid;
                                                                                                                if (target<nums[mid]) right = mid;
                                                                                                                            else left = mid;
                                                                                                                                    }
                                                                                                                                        }
                                                                                                                                        
}