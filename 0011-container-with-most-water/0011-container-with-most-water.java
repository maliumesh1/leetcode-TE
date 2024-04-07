// class Solution {
//     public int maxArea(int[] height) {

//         int maxwater=0;
//         for(int i =0 ; i<height.length ; i++)
//         {
//             for(int j=i+1 ; j<height.length ; j++)
//             {
//                 int ht = Math.min(height[i],height[j]);
//                 int width = j-i;

//                 int currwater = ht *width ;
//                 maxwater= Math.max(maxwater,currwater);
//             }
//         }
//         return maxwater;   
//     }
// }


// import java.util.*;
// class Solution {
//     public int maxArea(ArrayList<Integer> height) {

//         int maxwater=0;
//         for(int i =0 ; i<height.size() ; i++)
//         {
//             for(int j=i+1 ; j<height.size() ; j++)
//             {
//                 int ht = Math.min(height.get(i),height.get(j));
//                 int width = j-i;

//                 int currwater = ht *width ;
//                 maxwater= Math.max(maxwater,currwater);
//             }
//         }
//         return maxwater;   
//     }
// }




class Solution {
    public int maxArea(int[] height) {
        int lp = 0 ;
        int rp = height.length-1;
        int maxwater=0;

        while(lp != rp)
        {
            int ht = Math.min(height[lp] , height[rp]);
            int width = rp-lp;
            int currwater = ht * width ;
            
            maxwater = Math.max(currwater, maxwater);
            if(height[lp] < height[rp])
            {
                lp++;
            }
            else {
                rp--;
            }
        } 
      return maxwater;
        
    }
}