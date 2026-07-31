class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

    int n = mat.length;

    for (int k = 0; k < 4; k++) {

      if(Arrays.deepEquals(mat, target)){
        return true;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if(i < j){
            int temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
          }
        }
      }

      int colE = n-1;
      for (int i = 0; i <= (n-1)/2; i++) {
        for (int j = 0; j < n; j++) {
          int temp = mat[j][colE];
          mat[j][colE] = mat[j][i];
          mat[j][i] = temp;
        }
        colE--;
      }


    }

    return false;

  }

}