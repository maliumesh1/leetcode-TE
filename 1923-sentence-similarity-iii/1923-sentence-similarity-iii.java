class Solution {
        public boolean areSentencesSimilar(String sent1, String sent2) {
                String first = sent1;
                        String sec = sent2;
                                if(first.length()==sec.length()){
                                            return first.equals(sec);
                                                    }
                                                            if(sent2.length()<first.length()){
                                                                        first = sent2;
                                                                                    sec = sent1;
                                                                                            }
                                                                                                    int i = -1;
                                                                                                          while(i+1<first.length() && first.charAt(i+1)==sec.charAt(i+1)){
                                                                                                                  i++;
                                                                                                                        }
                                                                                                                                int j = first.length();
                                                                                                                                        int last = sec.length();
                                                                                                                                              while(j-1>=0 && first.charAt(j-1)==sec.charAt(last-1)){
                                                                                                                                                      j--;
                                                                                                                                                              last--;
                                                                                                                                                                    }

                                                                                                                                                                          if(i==first.length()-1 && sec.charAt(i+1)==' '){
                                                                                                                                                                                  return true;
                                                                                                                                                                                        } 
                                                                                                                                                                                              if(j==0 && sec.charAt(last-1)==' '){
                                                                                                                                                                                                      return true;
                                                                                                                                                                                                            }
                                                                                                                                                                                                                   if(i+1>=j && sec.charAt(i)==' ' && sec.charAt(last)==' '){
                                                                                                                                                                                                                               return true;
                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                   return false;
                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                       
}