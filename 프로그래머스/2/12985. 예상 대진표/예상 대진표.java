/* 4->2, 7->4
2->1, 4->2
1->1, 2->1 => 총 3번
*/
import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            a = (a+1)/2;
            b = (b+1)/2;
            
            answer++;
            
            if(a==b) {
                break;
            }
        }
        

        return answer;
    }
}