class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        /*

         READ BELOW FOR OVERALL EXPLANATION

        the general approach of our problem is simple:
        we start assuming that all squares are unguarded (ie. n * m unguarded squares), 
        then as we (a) initialize board and (b) check guards' cardinal direction, 
        we progressively start deducting from our "unguarded" count;


        our markers are the following:
         0 = empty (all coordinates initialized to this when we create array)
         1 = wall
         2 = guards
         3 = already visited (we use this flag so that we don't double subtract from our unguarded count)


         Big Oh: Our complexity is O(n * m) as we iterate through all of the squares a constant amount of times

         Performance: code beats 100 % in Java, so overall the solution is simple and extremely effective
        */


        // initializing necessary variables
        int[][] board = new int[m][n]; // here, all elements as initialized to 0
        int unguarded = m * n; // as we discussed, we start assuming that all squares are unguarded

        // initializing constants for improved code clarity
        final int VISITED = 3;
        final int GUARD = 2;
        final int WALL = 1;

        
        

        // initializing our guard coordinates, subtracting from 
        for(int[] coordinate : guards){
            int row = coordinate[0];
            int column = coordinate[1];

            // setting square to guard, and subtracting from unguarded
            board[row][column] = GUARD;
            unguarded--;
        }

        // initializing wall coordiantes
        for(int[] coordinate : walls){
            int row = coordinate[0];
            int column = coordinate[1];

            // setting square to 
            board[row][column] = 1;
            unguarded--;
        }

        for(int row = 0 ; row < m ; row++){
            for(int column = 0 ; column < n ; column++){

                // if we only care about guards, so we disregard all other flags/types and skip over them
                if(board[row][column] != GUARD) continue;

                

                /*
                the first expression of while loop checks that we are in bounds
                next we check if we have hit a guard or wall, in which case we stop searching
                this cardinal direction

                below we check squares to the left of current guard to see if they are guarded
                */
                int left = row;
                while(--left >= 0 && board[left][column] != GUARD && board[left][column] != WALL){

                    if(board[left][column] == VISITED) continue;


                    // we mark as covered, so future iterations don't double count it
                    board[left][column] = VISITED;
                    unguarded--;
                }

                

                /*
                the first expression of while loop checks that we are in bounds
                next we check if we have hit a guard or wall, in which case we stop searching
                this cardinal direction

                below we check squares to the right of our current guard to see if they are guarded
                */
                int right = row;
                while(++right < m && board[right][column] != GUARD && board[right][column] != WALL){
                    if(board[right][column] == VISITED) continue;
                    board[right][column] = VISITED;
                    unguarded--;
                }

                

                /*
                the first expression of while loop checks that we are in bounds
                next we check if we have hit a guard or wall, in which case we stop searching
                this cardinal direction

                below we check squares above our current guard to see if they are guarded
                */
                int up = column;
                while(++up < n && board[row][up] != GUARD && board[row][up] != WALL){
                    if(board[row][up] == VISITED) continue;
                    board[row][up] = VISITED;
                    unguarded--;
                }

                // add square below guard
                

                /*
                the first expression of while loop checks that we are in bounds
                next we check if we have hit a guard or wall, in which case we stop searching
                this cardinal direction

                below we check squares below our current guard to see if they are guarded
                */

                int down = column;
                while(--down >= 0 && board[row][down] != GUARD && board[row][down] != WALL){
                    if(board[row][down] == VISITED) continue;
                    board[row][down] = VISITED;
                    unguarded--;
                }
            }
        }

        // we are done, so we return unguarded. How about that for simplicity!
        return unguarded;  
    }
}