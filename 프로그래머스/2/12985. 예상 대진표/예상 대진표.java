//푸는 방법 까먹음
import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while(true) {
            a = (a+1) / 2;  //a가 4일 경우 (4+1)/2 = 2이다 = 2번 경기라는 뜻 (a가 3이여도 +1을 하기 때문에 2번 경기가 됨)
            b = (b+1) / 2;
            
            answer++;
            
            //a랑 b가 같아지면 같은 경기에서 만났다는 뜻
            if(a==b) {
                break;
            }
        }

        return answer;
    }
}