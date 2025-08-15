class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 1){
            return singleSearch(matrix, target, 0, 0, matrix[0].length);
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] < target){
                row++;
            } else{
                col--;
            }
        }
        return false;
    }

    public boolean singleSearch(int[][] matrix, int target , int row, int sCol, int eCol){
        while(sCol < eCol){
            if(matrix[row][sCol] == target){
                return true;
            } else if(matrix[row][sCol] < target){
                sCol++;
            } else{
                eCol--;
            }
        }
        return false;
    }
}