class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int sRow = 0;
        int sCol = 0;
        int eRow = m-1;
        int eCol = n-1;

        while(sRow <= eRow && sCol <= eCol){
            for(int j = sCol; j <= eCol && (sRow <= eRow && sCol <= eCol); j++){
                list.add(matrix[sRow][j]);
                count++;
            }
            sRow++;

            for(int i = sRow; i <= eRow && (sRow <= eRow && sCol <= eCol); i++){
                list.add(matrix[i][eCol]);
                count++;
            }
            eCol--;

            for(int j = eCol; j >= sCol && (sRow <= eRow && sCol <= eCol); j--){
                list.add(matrix[eRow][j]);
                count++;
            }
            eRow--;

            for(int i = eRow; i >= sRow && (sRow <= eRow && sCol <= eCol); i--){
                list.add(matrix[i][sCol]);
                count++;
            }
            sCol++;
        }
        return list;
    }
}