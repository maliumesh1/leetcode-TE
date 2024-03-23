class Solution {
    public int[][] generateMatrix(int n) {
       int rowSt = 0, rowEnd = n - 1, colSt = 0, colEnd = n - 1;
        int[][] arr =  new int[n][n];
        int val = 1;
        while(val <= n * n){
            //To fill first row
            for(int i = colSt; i <= colEnd; i++){
                arr[rowSt][i] = val++;
            }
            //To fill last col
            for(int i = rowSt + 1; i <= rowEnd; i++){
                arr[i][colEnd] = val++;
            }
            //TO fill last row
            if(rowEnd != rowSt){
                for(int i = colEnd - 1; i >= colSt; i--){
                    arr[rowEnd][i] = val++;
                }
            }
            //TO fill first col
            if(colEnd != colSt){
                for(int i = rowEnd - 1; i > rowSt; i--){
                    arr[i][colSt] = val++;
                }
            }
            rowSt++;
            rowEnd--;
            colSt++;
            colEnd--;
        }
        return arr;
    }
}