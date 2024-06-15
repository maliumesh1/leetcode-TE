class Solution {
    public void nextPermutation(int[] nums) {
                int ind1=-1;
        int ind2=-1;

        // step 1 find breaking point . to breaking pt cha idex I as ind1 mhanun save kra.
        for( int i=nums.length-2;  i >= 0 ; i--)
       {
            if(nums[i]<nums[i+1])
             {
                ind1=i;
                break;
            }
        }

        // if there is no breaking  point . jr breaking pt nasel tr arr rev kra…
        if(ind1==-1){
            reverse(nums,0);
        }
        
        else
         {    // JR  breaking pt asel tr 
            // step 2 find next greater element and swap with ind2

            for(int i=nums.length-1;i>=0;i--)
           {	
// JO BP CHYA NNANTR MOTHE ELE ASEL TO IND 2 MADHE SAVE KRA..
                if(nums[i]>nums[ind1]){
                    ind2=i;
                    break;
                }
            }

            swap(nums,ind1,ind2);

            // step 3 reverse the rest right half
            reverse(nums,ind1+1);
        }
    }

    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;

        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }

    }
}