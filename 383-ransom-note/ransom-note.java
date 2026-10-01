class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    int[] array = new int[26];

    Arrays.fill(array, 0);

    for (char i : magazine.toCharArray()) {
      array[122-(int)(i)]++;
    }

    for(char i : ransomNote.toCharArray()){
      if(array[122-(int)(i)] == 0){
        return false;
      } else{
        array[122 - (int)(i)]--;
      }
    }

    return true;
  }
}