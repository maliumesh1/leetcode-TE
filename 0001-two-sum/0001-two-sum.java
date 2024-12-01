// class Solution {
//     public int[] twoSum(int[] nums, int target) {

//       for(int i=0;i<nums.length;i++)
//         {
//             for(int j=i+1 ;j<nums.length;j++)
//             {
//                 if(nums[i] + nums[j] == target)
//                 {
//                     return new int [] {i,j};
//                 }
//             }
//         }
//         return new int [] {};
//     }
// }

//TC -N * N
//SC -1

//=================================================================================================

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j - i] + nums[j] == target) {
                    return new int[] { j - i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}

// TC -N * N
// SC -1

// | Aspect | Code 1 (Standard Version) | Code 2 (Adjusted Indexing) |
// |-------------------|------------------------------------|--------------------------------|
// | Readability | Simple and clear (i, j) | Less intuitive (j - i) |
// | Complexity | O(n^2) time, O(1) space | O(n^2) time, O(1) space |
// | Performance | Same as Code 2 | Same as Code 1 |
// | Maintainability | Easier to debug and modify | Harder to debug/modify |

// =================================================================================================
// OPTIMIZED TC AND SC


// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int arr[] = new int [2];
//         HashMap<Integer,Integer>mp = new HashMap<>();

//         for(int i=0 ;i<nums.length ;i++)
//         {
//             int first = nums[i];

//             int second  = target - first;

//             if(mp.containsKey(second))
//             {
//                 arr[0] = mp.get(second);
//                 arr[1] = i;
//                 return arr;
//             }
//             mp.put(nums[i],i);
//         }
//         return new int[] {};
//     }
// }

// TC -N
// SC -N

// =================================================================================================
// =================================================================================================
