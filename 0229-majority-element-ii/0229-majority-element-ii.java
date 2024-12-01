// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         ArrayList<Integer> al = new ArrayList<>();

//         int n=nums.length ;
//         int min=  n/3;

//         for(int i=0;i<n;i++)
//         {

//             if(al.size()==0 || al.get(0) != nums[i])
//             {
//                 int c=0;

//                for(int j=0;j<n;j++)
//                {
//                   if(nums[i] == nums[j])
//                    {
//                       c++;
//                    }
//                }

//                   if(c > min)
//                    {
//                       al.add(nums[i]);
//                    }

//                    if (al.size() == 2) break;
//             }
//         }
//         return al;
//     }
// }

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//      HashMap<Integer,Integer>hm = new HashMap<>();
//       ArrayList<Integer> al = new ArrayList<>();
//         int n = nums.length ;
//         int min =  n/3;

//      for(int i=0;i<n;i++)
//      {
//         hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
//      }

//         // Check for majority elements
//         for (int key : hm.keySet()) 
//         {
//             if (hm.get(key) > min) {
//                 al.add(key);
//             }
//         }

//     return al;

//     }
// }

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         ArrayList<Integer> al = new ArrayList<>();

//         int n=nums.length ;
//         int min=  n/3;

//         for(int i=0;i<n;i++)
//         {

//             if(al.size()==0 || al.get(0) != nums[i])
//             {
//                 int c=0;

//                for(int j=0;j<n;j++)
//                {
//                   if(nums[i] == nums[j])
//                    {
//                       c++;
//                    }
//                }

//                   if(c > min)
//                    {
//                       al.add(nums[i]);
//                    }

//                    if (al.size() == 2) break;
//             }
//         }
//         return al;
//     }
// }

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//      HashMap<Integer,Integer>hm = new HashMap<>();
//       ArrayList<Integer> al = new ArrayList<>();
//         int n = nums.length ;
//         int min =  n/3;

//      for(int i=0;i<n;i++)
//      {
//         hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
//      }

//         // Check for majority elements
//         for (int key : hm.keySet()) 
//         {
//             if (hm.get(key) > min) {
//                 al.add(key);
//             }
//         }

//     return al;

//     }
// }

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;

            } else if (num == candidate2) {
                count2++;

            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;

            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;

            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: kiti candidate aahet he bghate.
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Collect the majority elements
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result;
    }
}

// TC - N
// SC - 1
