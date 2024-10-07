class Solution {
        public int minLength(String s) {
                char[] stack = new char[s.length()+1];
                        int top=0;
                                for(char ch:s.toCharArray()){
                                            if(top==0){
                                                            stack[top++]=ch;
                                                                            continue;
                                                                                        }
                                                                                                    if((ch=='B' && stack[top-1]=='A')|| ch=='D' && stack[top-1]=='C'){
                                                                                                                    top--;
                                                                                                                                }
                                                                                                                                            else{
                                                                                                                                                            stack[top++]=ch;
                                                                                                                                                                        }
                                                                                                                                                                                }
                                                                                                                                                                                        return top;
                                                                                                                                                                                            }
                                                                                                                                                                                            
}