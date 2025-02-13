import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(true) {
            int temp = n % 10;
            answer += temp;
            n /= 10;
            
            if(n <= 0) {
                break;
            }
        }
        
        return answer;
    }
}