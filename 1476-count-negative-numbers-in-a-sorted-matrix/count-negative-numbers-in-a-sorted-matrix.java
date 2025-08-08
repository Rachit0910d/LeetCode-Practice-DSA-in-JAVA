class Solution {
    public int countNegatives(int[][] grid) {
        int row = 0;
        int cols = grid[0].length - 1;
        int rows = grid.length;
        int count = 0;
        while(row < rows && cols >= 0){

            if(grid[row][cols] >= 0){
                row++;
            } else{
                count = count + (rows-row);
                cols--;
            }
        }
        return count;
    }
}