//top-down 방식
//짝수일 때는 순간이동을 해서(*2) 간 것이므로 /2
//홀수일 때는 1칸 앞으로 간 것이므로 -1
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
            }
            else {
                n -= 1;
                
                //점프
                ans++;
            }
        }
    
        return ans;
    }
}