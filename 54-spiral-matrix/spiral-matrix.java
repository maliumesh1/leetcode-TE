class Solution {

    public List<Integer> spiralOrder(int[][] matrix){

        List<Integer> elements_list = new ArrayList<Integer>();

        for(int R = matrix.length , C = matrix[0].length , top_pointer = 0 , bottom_pointer = (R - 1) , left_pointer = 0 , right_pointer = (C - 1) ; ((top_pointer <= bottom_pointer) && (left_pointer <= right_pointer)) ; ){

            for(int j = left_pointer ; (j <= right_pointer) ; j++){
                elements_list.add(matrix[top_pointer][j]);
            }

            top_pointer++;

            for(int i = top_pointer ; (i <= bottom_pointer) ; i++){
                elements_list.add(matrix[i][right_pointer]);
            }

            right_pointer--;

            if(top_pointer <= bottom_pointer){

                for(int j = right_pointer ; (j >= left_pointer) ; j--){
                    elements_list.add(matrix[bottom_pointer][j]);
                }

                bottom_pointer -= 1;
            }

            if(left_pointer <= right_pointer){

                for(int i = bottom_pointer ; (i >= top_pointer) ; i--){
                    elements_list.add(matrix[i][left_pointer]);
                }

                left_pointer++;
            }
        }

        return elements_list;
    }
}