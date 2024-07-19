class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
             
                     List<Integer> ans = new ArrayList<>();
                             for(int i = 0; i< matrix.length; i++){
                                         
                                                     int minPosi = minRowVal(matrix[i]); //Get min Element per row
                                                                 int value = matrix[i][minPosi]; //Get value of min Element 
                                                                             if(isMaxCol(matrix, value, minPosi, i)){ //Check this element is max on column or not, if yes add to answer
                                                                                             ans.add(value);
                                                                                                         }
                                                                                                                 }
                                                                                                                         
                                                                                                                                 return ans;
                                                                                                                                     }
                                                                                                                                         
                                                                                                                                         	/* Find min element at row, return position of element*/
                                                                                                                                                private int minRowVal(int[] row){
                                                                                                                                                        
                                                                                                                                                                int ans = 0;
                                                                                                                                                                        for(int i = 1; i < row.length;i++){ 
                                                                                                                                                                                    
                                                                                                                                                                                                if(row[ans] > row[i]){
                                                                                                                                                                                                                ans = i;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            return ans;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                    		/* Check min Element is max on matrix column or not, return true if max*/
                                                                                                                                                                                                                                                                private boolean isMaxCol(int[][] matrix, int value, int col, int row){
                                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                                for(int i = 0; i< matrix.length;i++){
                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                        if(matrix[i][col] > value) return false;
                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                            return true;
                                                                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                    }
