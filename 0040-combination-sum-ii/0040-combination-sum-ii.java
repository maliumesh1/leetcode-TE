class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                List<List<Integer>> ans = new ArrayList<>();
                        List<Integer> ds = new ArrayList<>();
                                Arrays.sort(candidates);
                                        solve(0, ds, ans, candidates, target);
                                                return ans;
                                                    }
                                                        
                                                            void solve(int index, List<Integer> ds, List<List<Integer>> ans, int[] candidates, int target){
                                                                    // base case
                                                                            if(target == 0){
                                                                                        ans.add(new ArrayList<>(ds));
                                                                                                }
                                                                                                        
                                                                                                                for(int i = index; i<candidates.length; i++){
                                                                                                                            if(i>index && candidates[i]==candidates[i-1]){
                                                                                                                                            continue;
                                                                                                                                                        }
                                                                                                                                                                    
                                                                                                                                                                                if(candidates[i]>target){
                                                                                                                                                                                                break;
                                                                                                                                                                                                            }
                                                                                                                                                                                                                        
                                                                                                                                                                                                                                    ds.add(candidates[i]);
                                                                                                                                                                                                                                                solve(i+1, ds, ans, candidates, target-candidates[i]);
                                                                                                                                                                                                                                                            ds.remove(ds.size()-1);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                            
}