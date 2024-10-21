//뒷자리부터 보기
//0,1,2,3,4면 올림버튼
//6,7,8,9면 내림버튼 (10에서 빼기) -> 바로 앞 숫자 +1
//5면 앞의 숫자 확인

import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int num = storey % 10;
            storey /= 10;
            
            if(num < 5) {
                answer += num;
            }
            else if(num > 5) {
                answer += (10-num);
                storey++;  //내림버튼을 눌러야 하기 때문에 +1
            }
            else {  //5일 경우
                if(storey % 10 >= 5) {  //앞의 숫자가 5보다 크거나 같다면 내림버튼 누르는 게 효율적
                    answer += (10-num);
                    storey++;
                }
                else {  //그 앞의 숫자가 5보다 작으면 올림버튼 누르는 게 효율적
                    answer += num;
                }
            }
        }
        
        return answer;
    }
}

//예시 -> 2554
/* 4일 경우 올림 버튼 +4, storey = 255
5이므로 앞의 숫자 확인 -> 55
60 -> 55는 5+4 = 9이다. 50 -> 55는 5+5=10이다 
그러므로 앞의 숫자를 올려서 내림버튼 누르는 게 최소값
storey=26됨 내림버튼 +4, 앞의 층 +1
결론: 4+5+4+3 = 16
복잡하다 참...*/