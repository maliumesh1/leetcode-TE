class Solution {
    public int[] twoSum(int[] nums, int target) 
    
    {
        
        for (int i=0; i<nums.length;i++) //phla no
        {
            for(int j=i+1 ;j<nums.length;j++) //dusra no
            {
                if (nums[j]==target-nums[i]) //jb dusra no target me je minus                                                      //hokar equalaayega tab 
                                       //target=6,1st no =4 ,4nd no =2
                                        //then 2 != 6 - 4   if equal then retun value
                {
                    return new int [] {i,j};
                }
            }
        }
        return null; //jb koi solu nhi hoga tb ye null return krega..um
    }
}