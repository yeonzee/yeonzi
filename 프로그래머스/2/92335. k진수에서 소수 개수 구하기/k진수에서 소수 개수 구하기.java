//int는 런타임오류 발생 -> Long형으로 변환
import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n%k);
            n /= k;
        }
        
        String str = "";
        for(int i=list.size()-1; i>=0 ; i--) {
            str += list.get(i);
        }
        
        //0을 기준으로 나누기
        String[] temp = str.split("0");
        
        for(String s:temp) {
            //빈 문자열 처리
            if(s.equals("")) {
                continue;
            }
            
            //소수 판별
            long num = Long.parseLong(s);
            
            boolean check = true;
            
            //1보다 큰 경우만 판단
            if(num > 1) {
                for(int i=2; i<=Math.sqrt(num); i++) {
                    //소수가 아님
                    if(num % i == 0) {
                       check = false;
                        break;
                    }
                }
                //소수가 맞다면 +1
                if(check) {
                    answer++;
                }
            }
            
            
        }
        
        return answer;
    }
}