class Solution {

    

    public int smallestDistancePair(int[] nums, int k) {
     Arrays.sort(nums); 
        int n = nums.length; 
        int l = 0; 
        int r = nums[n-1] - nums[0]; 
        
        while(l < r){
            int m = l+ (r-l) / 2; 

            if(condition(nums, m)>=k){
                r = m; 
            }else {
                l = m +1; 
            }
            
        }
        return l;
                
    }
    
    
    private int condition(int [] nums, int mid){
        
        int total = 0; 
        int left = 0;
        for(int right =0 ; right < nums.length; right++){
            
            while(nums[right] - nums[left] > mid){
                left++; 
            }
            total += right - left; 
        }
        return total;
    }
}