import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int j=1;j<=n;j++) {
            int aa = 0;
            for (int i=j;i<=n;i++) {
                aa += i;
                if (aa == n) {
                    answer++;
                    break;
                }
                else if (aa>n) {
                    break;
                }
            }
        }
        return answer;
    }
}