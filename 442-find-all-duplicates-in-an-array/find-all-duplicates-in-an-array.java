class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int[] b = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            b[nums[i]-1]++;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<b.length;i++){
            if(b[i]==2) res.add(i+1);
        }
        return res;
    }
}