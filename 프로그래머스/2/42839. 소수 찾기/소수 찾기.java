import java.util.*;
class Solution {
    //중복제거
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        recursive("", numbers);
        
        
        boolean[] check = new boolean[set.size()];
        //소수인지 확인
        int idx = 0;
        for(int num:set) {
            if(num==0 || num==1) {
                check[idx] = false;
            }
            else {
                boolean isprime = true;
                for(int j=2; j<=Math.sqrt(num); j++) {
                    if(num % j == 0) {  //소수가 아님
                        isprime = false;
                        break;
                    }
                }
                check[idx] = isprime;
            }
            idx++;
        }
        
        for(int i=0; i<check.length; i++) {
            if(check[i]) {
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
            recursive(s+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }
}