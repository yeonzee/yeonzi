import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        //수 만들기
        recursive("", numbers);
        
        //소수 판별
        for(int n:set) {
            //소수라면
            if(prime(n)) {
                answer++;
            }
        }
        
        //확인용
        // System.out.println("numbers: " + set);
        // for(int n:set) {
        //     System.out.println("Checking: " + n + " -> " + prime(n));
        // }
        
        return answer;
    }
    
    //수 만들기
    public void recursive(String s, String others) {
        //비어있지 않은 문자열이라면 set에 넣기
        if(!s.equals("")) {
            set.add(Integer.valueOf(s));
        }
        
        //재귀
        for(int i=0; i<others.length(); i++) {
            recursive(s+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }
    
    public boolean prime(int n) {
        if(n == 0 || n == 1) {
            return false;
        }

        for(int j = 2; j <= Math.sqrt(n); j++) {
            if(n % j == 0) {
                return false;  //약수가 발견되면 바로 false 반환
            }
        }

        return true;  //끝까지 약수가 없으면 true 반환
    }
}