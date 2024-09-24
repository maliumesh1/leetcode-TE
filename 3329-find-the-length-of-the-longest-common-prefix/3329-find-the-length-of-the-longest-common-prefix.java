class Trie {
        Trie[] arr = new Trie[10];
        }
        class Solution {
            Trie root = new Trie();

                public int longestCommonPrefix(int[] arr1, int[] arr2) {
                        for(int ele : arr1) add_number(ele);

                                int result = 0;
                                        for(int ele : arr2) {
                                                    result = Math.max(result, find_depth(ele));
                                                            }
                                                                    return result;
                                                                        }

                                                                            void add_number(int num) {
                                                                                    Trie curr = root;
                                                                                            int multi = multi(num);
                                                                                                    while(multi > 0) {
                                                                                                                int d = (num / multi) % 10;
                                                                                                                            if(curr.arr[d] == null) curr.arr[d] = new Trie();
                                                                                                                                        curr = curr.arr[d];
                                                                                                                                                    multi /= 10;
                                                                                                                                                            }
                                                                                                                                                                }

                                                                                                                                                                    int find_depth(int num) {
                                                                                                                                                                            Trie curr = root;
                                                                                                                                                                                    int depth = 0;
                                                                                                                                                                                            int multi = multi(num);
                                                                                                                                                                                                    while(multi > 0) {
                                                                                                                                                                                                                int d = (num / multi) % 10;
                                                                                                                                                                                                                            if(curr.arr[d] == null) return depth;
                                                                                                                                                                                                                                        curr = curr.arr[d];
                                                                                                                                                                                                                                                    depth++;
                                                                                                                                                                                                                                                                multi /= 10;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                return depth;
                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                        int multi(int num) {
                                                                                                                                                                                                                                                                                                int multi = 1;
                                                                                                                                                                                                                                                                                                        while(multi * 10 <= num) {
                                                                                                                                                                                                                                                                                                                    multi *= 10;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                    return multi;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        
}