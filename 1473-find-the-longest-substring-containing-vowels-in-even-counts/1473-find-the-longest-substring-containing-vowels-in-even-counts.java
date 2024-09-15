class Solution {
        public int findTheLongestSubstring(String s) {
                int[] vowels = new int[26];
                        vowels['a' - 'a'] = ('a' - 'a') + 1;
                                vowels['e' - 'a'] = ('e' - 'a') + 1;
                                        vowels['i' - 'a'] = ('i' - 'a') + 1;
                                                vowels['o' - 'a'] = ('o' - 'a') + 1;
                                                        vowels['u' - 'a'] = ('u' - 'a') + 1;

                                                                int[] bitMask = new int[32];
                                                                        for(int i = 0; i < 32; ++i) bitMask[i] = -1;
                                                                                
                                                                                        int ans = 0;
                                                                                                int mask = 0;
                                                                                                        int idx = 0;
                                                                                                                
                                                                                                                        for(char c : s.toCharArray()){
                                                                                                                                    mask ^= vowels[c - 'a'];
                                                                                                                                                if(bitMask[mask] != -1 || mask == 0){
                                                                                                                                                                int curr = idx - bitMask[mask];
                                                                                                                                                                                if(ans < curr) ans = curr;
                                                                                                                                                                                            }
                                                                                                                                                                                                        else bitMask[mask] = idx;
                                                                                                                                                                                                                    ++idx;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                    return ans;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        
}