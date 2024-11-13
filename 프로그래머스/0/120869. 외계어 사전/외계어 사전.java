import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        Arrays.sort(spell);
        String sp = String.join("",spell);
        
        for(String s:dic) {
            String[] temp = s.split("");
            Arrays.sort(temp);
            
            String str = String.join("",temp);
            
            if(sp.equals(str)) {
                return 1;
            }
        }
        
        return 2;
    }
}