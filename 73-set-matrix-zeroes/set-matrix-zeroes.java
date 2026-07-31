class Solution {
    public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean setRowImpacted = false;
    boolean setColImpacted = false;

    // to find the first col element which is already 0
    for(int i = 0; i < n; i++){
      if(matrix[0][i] == 0){
        setColImpacted = true;
        break;
      }
    }

    // to find the first row element which is already 0
    for(int i = 0; i < m; i++){
      if(matrix[i][0] == 0){
        setRowImpacted = true;
        break;
      }
    }

    // finding 0 element and marking it's first row and col element to 0
    for(int i = 1; i< m; i++){
      for (int j = 1; j < n; j++) {
        if(matrix[i][j] == 0){
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // marking 0 to that element which col's or row's element is 0
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if(matrix[0][j] == 0 || matrix[i][0] == 0){
          matrix[i][j] = 0;
        }
      }
    }

    // if first row element is marked 0 before the main code, then set 0 to that rows element to 0
    if(setRowImpacted){
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }

    // if first col element is marked 0 before the main code, then set 0 to that col element to 0
    if(setColImpacted){
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }

  }

}