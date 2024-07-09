class Solution {
        public double averageWaitingTime(int[][] arr) {
                int prep_time=arr[0][0];
                        double wt_time=0;
                                for(int i=0;i<arr.length;i++)
                                        {
                                                    int arrival_time=arr[i][0];
                                                                if(prep_time<arrival_time)
                                                                            {
                                                                                            prep_time=arrival_time;
                                                                                                        }
                                                                                                                    int finish_time=prep_time+arr[i][1];
                                                                                                                                wt_time+=finish_time-arrival_time;
                                                                                                                                            prep_time=finish_time;
                                                                                                                                                    }
                                                                                                                                                            return wt_time/arr.length;
                                                                                                                                                                }
                                                                                                                                                                
}