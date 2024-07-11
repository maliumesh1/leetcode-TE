// 3.) Using Recursion
// T(N) : O(N) & S(N): O(N)
class Solution {

    int index = 0;

        private String reverseStringWithinBrackets(String str) {

                StringBuilder sb = new StringBuilder();

                        while(index < str.length()) {

                                    char ch = str.charAt(index);

                                                if(ch == '(') {

                                                                index++;
                                                                                String nextReversedStr = reverseStringWithinBrackets(str);
                                                                                                sb.append(nextReversedStr);

                                                                                                            } else if(ch == ')') {

                                                                                                                            index++;
                                                                                                                                            return sb.reverse().toString();
                                                                                                                                                        
                                                                                                                                                                    } else {

                                                                                                                                                                                    sb.append(ch);
                                                                                                                                                                                                    index++;

                                                                                                                                                                                                                }
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                return sb.toString();
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                            public String reverseParentheses(String s) {

                                                                                                                                                                                                                                                    return reverseStringWithinBrackets(s);
                                                                                                                                                                                                                                                        } 
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        // 2.) Using Wormhole Teleportation Technique
                                                                                                                                                                                                                                                        // T(N) : O(N) & S(N): O(N)
                                                                                                                                                                                                                                                        // class Solution {
                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                            //     public String reverseParentheses(String s) {

                                                                                                                                                                                                                                                            //         int n = s.length();

                                                                                                                                                                                                                                                            //         // Creating Open-to-Close & Close-Open Brackets Connection using Stack and Array

                                                                                                                                                                                                                                                            //         Stack<Integer> parenthesesIndices = new Stack<>();
                                                                                                                                                                                                                                                            //         int[] pairs = new int[n];

                                                                                                                                                                                                                                                            //         for(int i = 0; i < n; i++) {

                                                                                                                                                                                                                                                            //             char ch = s.charAt(i);

                                                                                                                                                                                                                                                            //             if(ch == '(') {

                                                                                                                                                                                                                                                            //                 parenthesesIndices.push(i);

                                                                                                                                                                                                                                                            //             }

                                                                                                                                                                                                                                                            //             if(ch == ')') {

                                                                                                                                                                                                                                                            //                 int temp = parenthesesIndices.pop();

                                                                                                                                                                                                                                                            //                 pairs[i] = temp;
                                                                                                                                                                                                                                                            //                 pairs[temp] = i;

                                                                                                                                                                                                                                                            //             }
                                                                                                                                                                                                                                                            //         }

                                                                                                                                                                                                                                                            //         // Using Wormhole Teleportation to Reverse the String within the Brackets

                                                                                                                                                                                                                                                            //         StringBuilder reversedString = new StringBuilder();

                                                                                                                                                                                                                                                            //         for(int i = 0, direction = 1; i < n; i += direction) {

                                                                                                                                                                                                                                                            //             char ch = s.charAt(i);

                                                                                                                                                                                                                                                            //             if(ch == '(' || ch == ')') {

                                                                                                                                                                                                                                                            //                 i = pairs[i];

                                                                                                                                                                                                                                                            //                 direction = -direction;

                                                                                                                                                                                                                                                            //             } else {

                                                                                                                                                                                                                                                            //                 reversedString.append(ch);
                                                                                                                                                                                                                                                            //             }
                                                                                                                                                                                                                                                            //         }

                                                                                                                                                                                                                                                            //         return reversedString.toString();
                                                                                                                                                                                                                                                            //     }
                                                                                                                                                                                                                                                            // }


                                                                                                                                                                                                                                                            // 1.) Using Stack & Brute Force
                                                                                                                                                                                                                                                            // T(N) : O(N^2) & S(N): O(N)
                                                                                                                                                                                                                                                            // class Solution {

                                                                                                                                                                                                                                                            //     private void addBackToStack(Stack<Character> stack, StringBuffer sb) {

                                                                                                                                                                                                                                                            //         for(int i = 0; i < sb.length(); i++) {

                                                                                                                                                                                                                                                            //             stack.push(sb.charAt(i));

                                                                                                                                                                                                                                                            //         }
                                                                                                                                                                                                                                                            //     }

                                                                                                                                                                                                                                                            //     private String createStringFromStack(Stack<Character> stack) {

                                                                                                                                                                                                                                                            //         StringBuffer sb = new StringBuffer();

                                                                                                                                                                                                                                                            //         while(!stack.isEmpty()) {

                                                                                                                                                                                                                                                            //             sb.append(stack.pop());

                                                                                                                                                                                                                                                            //         }

                                                                                                                                                                                                                                                            //         return sb.reverse().toString();
                                                                                                                                                                                                                                                            //     }
                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                //     public String reverseParentheses(String s) {

                                                                                                                                                                                                                                                                //         Stack<Character> stack = new Stack<>();

                                                                                                                                                                                                                                                                //         for(int i = 0; i < s.length(); i++) {

                                                                                                                                                                                                                                                                //             char ch = s.charAt(i);

                                                                                                                                                                                                                                                                //             if(ch != ')') {

                                                                                                                                                                                                                                                                //                 stack.push(ch);

                                                                                                                                                                                                                                                                //             } else {

                                                                                                                                                                                                                                                                //                 StringBuffer sb = new StringBuffer();

                                                                                                                                                                                                                                                                //                 while(stack.peek() != '(') {

                                                                                                                                                                                                                                                                //                     sb.append(stack.pop());

                                                                                                                                                                                                                                                                //                 }

                                                                                                                                                                                                                                                                //                 stack.pop();

                                                                                                                                                                                                                                                                //                 addBackToStack(stack, sb);
                                                                                                                                                                                                                                                                //             }
                                                                                                                                                                                                                                                                //         }

                                                                                                                                                                                                                                                                //         return createStringFromStack(stack);
                                                                                                                                                                                                                                                                //     }
                                                                                                                                                                                                                                                                // }