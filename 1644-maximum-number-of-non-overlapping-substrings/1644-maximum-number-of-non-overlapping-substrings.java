class Solution {
  public List<String> maxNumOfSubstrings(String s) {
        int[][] range = new int[26][2];
            int n = s.length();
                for (int i = 0; i < 26; i++) {
                        range[i] = new int[]{n, 0};
                            }
                                List<String> res = new ArrayList<>();
                                    char[] arr = s.toCharArray();
                                        for (int i = 0; i < n; i++) {
                                                int ch = arr[i] - 'a';
                                                        range[ch][0] = Math.min(range[ch][0], i);
                                                                range[ch][1] = Math.max(range[ch][1], i);
                                                                    }
                                                                        int right = n;
                                                                            for (int i = 0; i < n; ++i) {
                                                                                    if (i == range[arr[i] - 'a'][0]) {
                                                                                                int newRight = checkSubstring(arr, i, range);
                                                                                                            if (newRight != -1) {
                                                                                                                            if (i <= right && res.size() != 0) {
                                                                                                                                                //if we find legal char less than i
                                                                                                                                                                    res.set(res.size() - 1, s.substring(i, newRight + 1));
                                                                                                                                                                                    } else {
                                                                                                                                                                                                        res.add(s.substring(i, newRight + 1));
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        right = newRight;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                    return res;
                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                    int checkSubstring(char[] arr, int i, int[][] range) {
                                                                                                                                                                                                                                                                        int right = range[arr[i] - 'a'][1];
                                                                                                                                                                                                                                                                            for (int j = i; j <= right; ++j) {
                                                                                                                                                                                                                                                                                    int index = arr[j] - 'a';
                                                                                                                                                                                                                                                                                            if (range[index][0] < i) {
                                                                                                                                                                                                                                                                                            			//it mean this char is illegal. 
                                                                                                                                                                                                                                                                                                        			//"abab" is "abab", not "bab"
                                                                                                                                                                                                                                                                                                                                return -1;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                right = Math.max(right, range[index][1]);
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                        return right;
                                                                                                                                                                                                                                                                                                                                                        
  }
}