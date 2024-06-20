class Solution {

    String alpabet = "AEIOU"; 
    String [] dict = alpabet.split("");
    int result = 0 ; 
    int count = 0 ; 
    public int   solution(String word) {
        StringBuilder sb = new StringBuilder(); 
        dfs(5,0,sb,word);
        return result ; 

    }
   public void dfs(int target, int cnt , StringBuilder sb,String word) {
        if(sb.toString().equals(word)) {
            result = count ; 
            return ; 
        }

        if(target == cnt ) {
            return ; 
        }

        for(int i = 0 ; i < dict.length; i ++) {
            sb.append(dict[i]); 
            count ++; 
            dfs(target,cnt +1, sb,word); 
            sb.deleteCharAt(sb.length()-1); 

        }

    }

}