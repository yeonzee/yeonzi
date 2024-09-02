import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        
        int answer = 0;
        
        //중복없이 모든 조합 set에 저장
        recursive("", numbers);
        
        for(int num:set) {
            if(isboolean(num)) {  //소수라면
                answer++;
            }
        }
        return answer;
    }
    
    public void recursive(String s, String others) {
        if(!s.equals("")) {
            set.add(Integer.valueOf(s));
        }
        
        for(int i=0; i<others.length(); i++) {
            //재귀
            recursive(s+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }
    
    public boolean isboolean(int num) {
        if(num==0 || num==1) {
            return false;
        }
        else{
            for(int i=2; i<=Math.sqrt(num); i++) {
                if(num % i == 0) { //소수아님
                    return false;
                }
            }
        }
        return true;
    }
}