// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         for(int i=0;i<n;i++)
//         {
//             int c=0;

//             for(int j=0;j<n;j++)
//             {
//                 if(nums[i] == nums[j])
//                 {
//                     c++;
//                 }
//             }

//             if(c>n/2)
//             {
//                 return nums[i];
//             }
//         }
//         return -1;

//     }
// }

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer, Integer>mp = new HashMap<>();

//         for(int num : nums)
//         {
//             mp.put(num, mp.getOrDefault(num, 0) + 1);

//             if(mp.get(num)>n/2)
//            {
//             return num;
//             }
//         }
//      return -1;
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int c = 0;
        int ele = 0;

        for (int i = 0; i < n; i++) {
            if (c == 0) {

                ele = nums[i];
                c = 1;
            }

            else if (ele == nums[i]) {
                c++;
            }

            else {
                c--;
            }
        }

        c = 0;
        for (int i = 0; i < n; i++) {
            if (ele == nums[i]) {
                c++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (c > n / 2) {
                return ele;
            }
        }
        return -1;
    }
}