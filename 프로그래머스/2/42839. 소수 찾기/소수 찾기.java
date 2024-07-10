//모든 조합 만들기(중복을 피하기 위해 set사용)
//소수인지 확인
import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        recursive("",numbers);
        
        for(int num:set) {
            if(isboolean(num)) {
                //소수임
                answer++;
            }
        }
        
        
        return answer;
    }
    
    //모든 조합 중복없이 set에 저장
    public void recursive(String s, String others) {
        if(!s.equals("")) {
            set.add(Integer.valueOf(s));
        }
        
        //재귀
        for(int i=0; i<others.length(); i++) {
            recursive(s+others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
        
    }
    
    //소수인지 확인
    public boolean isboolean(int num) {
        if (num==0 || num == 1) {
            return false;
        }
        else {
            for(int i=2; i<=(int)Math.sqrt(num); i++) {
                //소수아님
                if(num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
}