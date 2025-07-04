class Solution {
    public boolean checkIfPangram(String sentence) {
        int count = 0;
        char alphabet = (char)(97);

        for(int i = 0; i < sentence.length(); i++){
            for(int j = 0; j < sentence.length(); j++){
                if(alphabet == sentence.charAt(j)){
                count++;
                alphabet++;
                }
            }
        }
        if(count == 26){
            return true;
        }
        else{
            return false;
        }

        
    }
}