import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        //인덱스 순으로 넣기 위해
        String[] arr = {"4","1","2"};
        
        while(n>0) {
            //n을 3으로 나눈 인덱스 값 저장
            int remainder = n % 3;
            //그 앞자리를 구하기 위해 3으로 나누어주기
            n /= 3;
            
            //만약 n을 3으로 나눈 값이 0이라면 n에서 1을 빼주기 (0이 없기 때문에)
            if(remainder == 0) {
                n--;
            }
            
            answer = arr[remainder] + answer;
        }
        return answer;
    }
}