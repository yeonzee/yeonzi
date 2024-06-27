//number의 길이에서 k를 뺀 값 = 문자의 길이
//뒤에서부터 문자의 길이-1을 제외한 앞 문자중에 가장 큰 값 뽑기
//그 값의 뒷값부터 차례로 구하기
//탐욕법은 뒤에서부터 찾아가는 게 좋음
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        //만든 문자열의 길이
        int len = number.length() - k;
        
        //start는 가장 큰 값을 뽑은 후 다음 수부터 그 다음 큰 값을 뽑아야 하기 때문에 만든 변수
        int start = 0;
        for(int i=0;i<len;i++) {
            char max = '0';
            for(int j=start;j<=i+k;j++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    start = j+1;
                }
                //시간효율성을 높이기 위해 9면 break
                if(max=='9'){
                    break;
                }
            }
            answer += Character.toString(max);
        }
        return answer;
    }
}