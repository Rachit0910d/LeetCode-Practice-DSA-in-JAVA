class Solution {

    class Pair{
        char ch;
        int count;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek().ch == c){
                st.peek().count++;
            } else{
                st.push(new Pair(c, 1));
            }

            if(st.peek().count == k){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair p : st){
            for(int i =0; i < p.count; i++){
                sb.append(p.ch);
            }
        }

    return sb.toString();
    }
}