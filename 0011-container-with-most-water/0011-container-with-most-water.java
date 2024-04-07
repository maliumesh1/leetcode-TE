//-------------------------------------------------------------------------------------------------------------

// BRUTE FORCE TC O(N^2) USING ARRAY  (TIME CONSUMING )
//______________________________________

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

//-------------------------------------------------------------------------------------------------------------
// BRUTE FORCE TC O(N^2) USING ARRAYLIST   (NOT RUN IN THIS DRIVER CODE)
//______________________________________
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

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
// OPTIMAL TC O(N)  USING ARRAY
// class Solution {
//     public int maxArea(int[] height) {
//         int lp = 0 ;
//         int rp = height.length-1;
//         int maxwater=0;

//         while(lp != rp)
//         {
//             int ht = Math.min(height[lp] , height[rp]);
//             int width = rp-lp;
//             int currwater = ht * width ;
            
//             maxwater = Math.max(currwater, maxwater);
//             if(height[lp] < height[rp])
//             {
//                 lp++;
//             }
//             else {
//                 rp--;
//             }
//         } 
//       return maxwater;
        
//     }
// }



//-------------------------------------------------------------------------------------------------------------
// OPTIMAL TC O(N)  USING ARRAY LIST (NOT RUN IN THIS DRIVER CODE)
// class Solution {
//     public int maxArea(ArrayList<Integer> height) {

//         int lp = 0 ;
//         int rp = height.size()-1;
//         int maxwater=0;

//         while(lp != rp)
//         {
//             int ht = Math.min(height.get(lp) , height.get(rp));
//             int width = rp-lp;
//             int currwater = ht * width ;
            
//             maxwater = Math.max(currwater, maxwater);
//             if(height.get(lp) < height.get(rp))
//             {
//                 lp++;
//             }
//             else {
//                 rp--;
//             }
//         } 
//       return maxwater;
        
//     }
// }

//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------


class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * (right - left);
            maxWater = Math.max(maxWater, area);

            while (height[left] <= minHeight && left < right) {
                left++;
            }

            while (height[right] <= minHeight && left < right) {
                right--;
            }
        }

        return maxWater;
    }
}