class Solution {
    public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(i < j){
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }

    int colE = n-1;
    for (int i = 0; i <= (n-1)/2; i++) {
      for (int j = 0; j < n; j++) {
        int temp = matrix[j][colE];
        matrix[j][colE] = matrix[j][i];
        matrix[j][i] = temp;
      }
      colE--;
    }

  }

}