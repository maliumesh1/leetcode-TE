class Solution {
        public int getLucky(String s, int k) {
                int digitSum = 0;
                      
                              //System.out.println("##  k =" + k + " s="+ s + " length ="+ s.length());
                                      StringBuilder newString = new StringBuilder();
                                              for(char ch : s.toCharArray()){
                                                          int pos = (ch - 'a') + 1;
                                                                      digitSum = digitSum + pos/10 + pos%10;
                                                                                  //System.out.println(" ch =" + ch + " pos="+ pos + " digitSum ="+ digitSum);
                                                                                          }
                                                                                                  k--;
                                                                                                          while(k > 0){
                                                                                                                      int newDigitSum = 0;
                                                                                                                                  //System.out.println("##  k =" + k + " digitSum ="+ digitSum );
                                                                                                                                              //newString.setLength(0);
                                                                                                                                                          while(digitSum > 0 ){
                                                                                                                                                                          newDigitSum  = newDigitSum + digitSum % 10;
                                                                                                                                                                                          digitSum = digitSum/10;
                                                                                                                                                                                                      }
                                                                                                                                                                                                                  k--;
                                                                                                                                                                                                                              digitSum = newDigitSum;
                                                                                                                                                                                                                                          //    System.out.println("--  k =" + k + " s="+ s + " digitSum ="+ digitSum);
                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                          return digitSum;
                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                              
}