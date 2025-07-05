class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i = 0;  i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if((i==j) || (j == mat[i].length - 1 - i)){
                    sum += mat[i][j];
                }
            }
        }
        //if(mat.length / 2 != 0)
       // return  sum - mat[mat.length/2][mat.length/2];
       // else{
            return sum;
       // }
    }
}