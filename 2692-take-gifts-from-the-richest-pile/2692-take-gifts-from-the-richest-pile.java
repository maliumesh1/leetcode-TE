class Solution {
    public long pickGifts(int[] gifts, int k)
        {
                int l = gifts.length;
                        long t = 0;
                                PriorityQueue<Integer> p = new PriorityQueue<>(l, (a,b)->b-a);

                                        for(int i=0; i<l; i++)
                                                {
                                                            p.offer(gifts[i]);
                                                                        t += gifts[i];
                                                                                }
                                                                                        
                                                                                                for(int i=0, m,n; i<k; i++)
                                                                                                        {
                                                                                                                    m = p.poll();

                                                                                                                                if(m==1)
                                                                                                                                                break;

                                                                                                                                                            n = (int)Math.floor(Math.sqrt(m));
                                                                                                                                                                        p.offer(n);
                                                                                                                                                                                    t -= m-n;
                                                                                                                                                                                            }

                                                                                                                                                                                                    return t;
                                                                                                                                                                                                        }
}