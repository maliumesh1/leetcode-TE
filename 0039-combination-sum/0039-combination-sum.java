class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        find(list, candidates, target, new ArrayList<Integer>(), 0);
        return list;
    }

    private void find(List<List<Integer>> list, int[] candidates, int target, ArrayList<Integer> temp, int i) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        if (i == candidates.length)
            return;

        // pick
        if (candidates[i] <= target) {
            temp.add(candidates[i]);
            find(list, candidates, target - candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }

        // not pick
        find(list, candidates, target, temp, i + 1);
    }

}