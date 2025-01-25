//3으로 나눈 몫 + 나머지 (String)
import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        
        //인덱스 순서로 넣기 위해
        String[] arr = {"4","1","2"};
        
        while(n!=0) {
            //3으로 나눈 나머지 값
            int remainder = n%3;
            
            //n은 3으로 나눈 몫으로 변경
            n /= 3;
            
            //나머지가 0이라면 n-1
            if(remainder == 0) {
                n--;
            }
            
            answer = arr[remainder] + answer;
            
        }
        return answer;
        
        
    }
}