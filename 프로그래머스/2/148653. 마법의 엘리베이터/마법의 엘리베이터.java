/*
storey = 현재 층 / 내가 가야하는 층: 0층
뒤에서부터 보기
0,1,2,3,4 -> - 버튼
6,7,8,9 -> + 버튼
5는 앞의 숫자와 합쳐서 판단
*/
import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int n = storey % 10;
            storey /= 10;
            
            if(n < 5) {
                answer += n;
            }
            else if(n > 5) {
                answer += 10-n;
                storey++;   //더 크게 내려가서 뒷 숫자만큼 올라와야 하기 때문에 +1
            }
            else if(n == 5) {
                //5 앞의 수가 5보다 크거나 같을 경우 더 큰 숫자에서 올라와야 함
                if(storey % 10 >= 5) {
                    answer += 10-n;
                    storey++;
                }
                //5 앞의 수가 5보다 작은 경우 거기서 내려가야 함
                else {
                    answer += n;
                }
            }
        }
        return answer;
    }
}