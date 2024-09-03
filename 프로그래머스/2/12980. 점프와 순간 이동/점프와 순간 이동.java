//top-down 형식으로 풀이
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(true) {
            if(n == 0) {
                break;
            }
            
            if(n % 2 == 0) {  //짝수인 경우는 순간이동
                n /= 2;
            }
            else {  //홀수인 경우는 점프
                n--;
                ans++;
            }
        }

        return ans;
    }
}