class CustomStack {

        int[] out;
            int i=-1,z;

                public CustomStack(int maxSize) {
                        out=new int[maxSize];
                                z=maxSize;
                                    }
                                        
                                            public void push(int x) {
                                                    if(i<z-1)
                                                                out[++i]=x;
                                                                    }
                                                                        
                                                                            public int pop() {
                                                                                    if(i>-1)
                                                                                                return out[i--];
                                                                                                        return -1;
                                                                                                                
                                                                                                                    }
                                                                                                                        
                                                                                                                            public void increment(int k, int val) {

                                                                                                                                    for(int j=0;j<(k>i?i+1:k);j++)
                                                                                                                                                out[j]+=val;
                                                                                                                                                        
                                                                                                                                                            }
                                                                                                                                                            
}