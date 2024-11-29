class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rot[][] = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                {
                    rot[j][n - 1 - i] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < rot.length; i++) {
            for (int j = 0; j < rot[0].length; j++) {
                matrix[i][j] = rot[i][j];
            }
        }
    }
}
// both the time and space complexity of the algorithm are O(n^2).

// -----------------------------------------------------------------------------------
// TC N*M and SC = 1
// class Solution {
// public void rotate(int[][] matrix) {
// // Step 1 - Find transpose of matrix
// for(int i=0;i<matrix.length;i++){
// for(int j=i;j<matrix[0].length;j++){
// int temp=0;
// temp= matrix[i][j];
// matrix[i][j]= matrix[j][i];
// matrix[j][i]= temp;
// }
// }
// // step 2 - Reverse each row of matrix
// for(int i=0;i<matrix.length;i++){
// for(int j=0;j<matrix.length/2;j++){
// int temp= matrix[i][j];
// matrix[i][j]= matrix[i][matrix.length-1-j];
// matrix[i][matrix.length-1-j]= temp;

// }
// }
// }
// }