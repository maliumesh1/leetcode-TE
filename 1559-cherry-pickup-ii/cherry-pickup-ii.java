/*


   ye hoga toh recursion se hi , par isme dono ke liye dp lagani padhegi wo bhi ek saath ; 

   means dono ko ek saath hi move karwana padhega taaki , hum agar wo same column par ho 
   // toh ek hi banda le sake usko ; 

   agar hum dono ke liye alag alag dfs lagayenge ; toh hum same cell ki cherry dono ke
   liye count karwa denge , jo ki galat hai, ek cell mein ek baar hi banda jaake 
   saare cherrry le lega ; 


   so yahaan dono ko ek saath le jaana padhega ; 


*/
class Solution {
    public int cherryPickup(int[][] grid) {
        


        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length] ; 


        for( int i = 0 ; i < grid.length ; i++)
        {
            for( int j = 0 ; j < grid[0].length ; j++)
            {
                for( int k = 0 ; k < grid[0].length; k++)
                {
                    dp[i][j][k] = -1 ; 
                }
            }
        }
         return helper( grid , 0 , 0 , grid[0].length-1 , dp) ; 

    }
    public int helper(int grid[][] ,  int row , int col1 , int col2 , int dp[][][] )
    {
        if( col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length || row >= grid.length )
        {
               return 0 ; 
        }

        
        if( dp[row][col1][col2] != -1)
        return dp[row][col1][col2] ; 

           int temp = 0 ; 
        



        int opt1 = helper(grid , row+1 , col1-1 , col2-1 , dp ) ; 

             temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1-1 , col2 , dp ) ; 

                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1-1 , col2+1 , dp ) ; 


                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1 , col2-1 , dp ) ; 

                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1 , col2  , dp ) ; 


                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1 , col2+1 , dp ) ; 

                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1+1 , col2-1 , dp ) ; 


                temp = Math.max(temp , opt1) ; 
              opt1 = helper(grid , row+1 , col1+1 , col2 , dp ) ;

                temp = Math.max(temp , opt1) ;  
              opt1 = helper(grid , row+1 , col1+1 , col2+1 , dp ) ; 


                temp = Math.max(temp , opt1) ; 



              if( col1 == col2)
        {
             temp += grid[row][col1] ; 
        }
        else
        {
             temp += grid[row][col1] + grid[row][col2] ; 
        }

        dp[row][col1][col2] = temp ; 
        return temp ; 
    }
}