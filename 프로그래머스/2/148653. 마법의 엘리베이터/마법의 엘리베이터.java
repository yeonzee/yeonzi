//dp
//0,1,2,3,4 일 경우 올림버튼
//6,7,8,9 일 경우 내림버튼 (10에서 빼기)
//5일 경우 그 앞의 숫자가 5보다 작으면 올림버튼
//그 앞의 숫자가 5이상일 경우 내림버튼
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int digit = storey % 10;
            storey /= 10;
            
            if(digit==5) {
                if(storey%10 >= 5) {
                    answer += (10-digit);
                    storey++;
                }
                else {
                    answer += digit;
                }
            }
            
            else if(digit > 5) {
                answer += (10-digit);
                storey++;
            }
            
            else {
                answer += digit;
            }
        }
        
        return answer;
    }
}

//storey++를 하는 이유: 281을 예시로 보자면 100 3번 -10 2번 1 1번 이 제일 적다
//8은 5보다 크므로 answer에 2를 더한다
//그 후에 값은 2가 되므로 storey++을 해줘야 한다 (난 100을 3번 썼으므로)
//+1을 하면 안되는 이유는 모르겠음... 망할