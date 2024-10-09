class Solution {
        public int minAddToMakeValid(String s) {
                int a = 0, b = 0; 
                        for(char ch : s.toCharArray())
                                {
                                            if(ch == '(')
                                                        {
                                                                        a++;
                                                                                    } 
                                                                                                else
                                                                                                            {
                                                                                                                            if(a > 0)
                                                                                                                                            {
                                                                                                                                                                a--;
                                                                                                                                                                                } 
                                                                                                                                                                                                else
                                                                                                                                                                                                                {
                                                                                                                                                                                                                                    b++;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                        } 
                                                                                                                                                                                                                                                                                return a+b;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    }