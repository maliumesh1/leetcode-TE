class Solution {
        
            private final String up = "../";
                private final String no = "./";
                    
                        public int minOperations(String[] logs)
                            {
                                    int dist = 0;
                                            
                                                    for(String op : logs)
                                                            {
                                                                        switch(op)
                                                                                    {
                                                                                                    case up:
                                                                                                                        if(dist>0)
                                                                                                                                                dist--;
                                                                                                                                                                    break;
                                                                                                                                                                                
                                                                                                                                                                                                case no:
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                default:
                                                                                                                                                                                                                                                                    dist++;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                        return dist;
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            
}