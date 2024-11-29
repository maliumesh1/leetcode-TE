//===========================================================================================================
//===========================================================================================================
//USING SUB-ARRAY PROPERTY................. Using Nested Loops (Brute Force)
// class Solution {
//     public int findDuplicate(int[] nums) {
//        for(int i=0; i<nums.length;i++)
//        {
//         for(int j=i+1 ;j<nums.length;j++)
//         {
//             if(nums[i] == nums[j])
//             {
//                 return nums[i] ;
//             }
//         }
//        }
//        return -1;
//     }
// }
// the time complexity is O(n^2) and the space complexity is O(1).

//========================================================================================================
// USING SORTING
//  the time complexity is O(n log n + n Travels) and the space complexity is O(1) if sorting is done in-place.

//  class Solution {
//     public int findDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         int numm =0;

//         for(int i=1;i<nums.length; i++)
//         {
//             if(nums[i-1] ==nums[i])
//             {
//                 numm =  nums[i];
//             }
//         }
//         return numm;
//     }
// }

// //===========================================================================================================
//===========================================================================================================
// USING HASH ARRAY
// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;

//        int arr[]= new int[n+1];
//        for(int i=0; i<n;i++)
//        {
//          if(arr[nums[i]] == 0)
//          {
//             arr[nums[i]]++ ;
//          }

//          else
//           return nums[i];
//        }
//        return -1;
//     }
// }

//In summary, the time complexity is O(n) and the space complexity is O(n).

//===========================================================================================================
//===========================================================================================================
//  USING  Floyd’s Cycle Detection Algorithm

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);

        fast = nums[0];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
// //Time Complexity: O(n)
// // Space Complexity: O(1)



//===========================================================================================================
//===========================================================================================================
// | Approach                   | Time Complexity | Space Complexity | Notes                                |
// |----------------------------|-----------------|------------------|--------------------------------------|
// | Nested Loops (Brute)       |     O(n^2)      | O(1)             | Inefficient, use only for small   n  |
// | Sorting                    |   (O(nlogn)+n   | O(1)             |Moderate performance; may affect input|
// | Hash Array                 |     O(n)        | O(n)             | Fast but consumes extra memory.      |
// | Floyd’s Cycle Detection    |     O(n)        | O(1)             | Best overall choice.-----            |
//==========================================================================================================
//===========================================================================================================
