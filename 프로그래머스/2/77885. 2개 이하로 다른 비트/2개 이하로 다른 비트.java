/*
1.짝수일때는 끝자리가 0이므로 원래 숫자에서 1을 더해주기 (비트가 1개 바뀐 경우)
2.홀수일때는 1로만 이루어졌는지 0도 있는지 확인
3.1로만 이루어져있는 경우: 맨 앞에 10을 추가하고 비트 자리수-1의 1을 채워주기
4.0도 있는 경우: 끝에서부터 처음 0이 나오는 곳에 10을 집어넣기
*/
import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++) {
            long num = numbers[i];
            //짝수라면
            if(num % 2 == 0) {
                answer[i] = num+1;
            }
            //홀수라면
            else {
                String s = Long.toString(num,2);
                //마지막으로 0이 오는 위치
                int idx = s.lastIndexOf("0");
                    
                //0이 있다면
                if(idx != -1) {
                    s = s.substring(0,idx) + "10" + s.substring(idx+2);
                    answer[i] = Long.parseLong(s,2);
                }
                //0이 없다면
                else {
                    s = "10" + s.substring(1);
                    answer[i] = Long.parseLong(s,2);
                }
            }
        }
        
        return answer;
    }
}