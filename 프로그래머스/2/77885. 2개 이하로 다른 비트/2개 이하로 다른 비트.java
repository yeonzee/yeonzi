/*
1. 짝수일 경우 맨 뒷자리는 무조건 0, 그러므로 +1만 해주면 됨
2. 홀수일 경우 뒤에서 0이 시작되는 인덱스를 10으로 바꿔주면 됨
3. 홀수인데 0이 없는 경우는 맨 앞에 10을 붙여주면됨
이런식으로 하면 비트가 다른 지점이 2개 이하이면서 가장 작은 수 완성
*/
import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            
            //짝수라면 +1
            if(num % 2 == 0) {
                answer[i] = num+1;
            }
            //홀수라면
            else {
                //2진수로 변환
                String str = Long.toString(num, 2);
                
                //0의 인덱스 확인
                int idx = str.lastIndexOf("0");
                
                //0이 있는 홀수라면
                if(idx != -1) {
                    str = str.substring(0, idx) + "10" + str.substring(idx+2);
                }
                //0이 없는(1로만 채워진) 홀수라면
                else {
                    str = "10" + str.substring(1);
                }
                
                answer[i] = Long.parseLong(str,2);
            }
        }
        return answer;
    }
}