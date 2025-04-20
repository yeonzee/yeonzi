//i*2 + j*2 <= d*2 -> j*2 <= d*2-i*2
import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        //거리
        long dis = (long)d*d;
        
        for(int i=0; i<=d; i+=k) {
            //i를 고정해놨을 때 갈 수 있는 거리
            long now_dis = (long)Math.sqrt(dis - (long)i*i);
            
            answer += (now_dis/k)+1;
        }
        return answer;
    }
}