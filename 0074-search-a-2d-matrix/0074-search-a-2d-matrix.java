// BRUTE FORCE
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         for(int i = 0 ; i<matrix.length ; i++)
//         {
//             for(int j = 0 ; j<matrix[0].length ; j++)
//             {
//                 if(matrix[i][j] == target)
//                 {
//                     return true;
//                 }
//             }

//         }
//         return false;
//      }
// }

//=============================================================================================
//=============================================================================================
//  staircase approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = SEARCH(matrix, target);
        return ans;

    }

    // 1 4 7 11
    // 2 5 8 12
    // 3 6 9 16
    // 10 13 14 17

    // Target: 5

    // Steps:
    // 1] Start at the top-right corner (matrix[0][3] = 11):

    // 2] 5 < 11: Move left to column 2 (matrix[0][2] = 7).
    // Check matrix[0][2] = 7:

    // 3] 5 < 7: Move left to column 1 (matrix[0][1] = 4).
    // Check matrix[0][1] = 4:

    // 4] 5 > 4: Move down to row 1 (matrix[1][1] = 5).
    // Check matrix[1][1] = 5:

    // Match found. Return true.

    public static boolean SEARCH(int [] [] matrix,int target ) {
    	 int row=0, col = matrix[0].length-1;
          
           while (row<matrix.length && col>=0)
           {
               if(matrix[row][col]==target){
                 return true;
                 }

                else if(target<matrix[row][col]){
                    col--;
                 }
                
                else {
                  row++;    
                 }
           }
       return false;
   }
}
