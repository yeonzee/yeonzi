//i^2+j^2 <= d^2  ->  j^2 <= d^2-i^2
import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        //효율성위해 for문 밖에서 계산
        long dis = (long)d*d;
        
        for(int i=0; i<=d; i+=k) {
            //현재에서 갈 수 있는 거리
            long now_dis = (long)Math.sqrt(dis - (long)i*i);
            
            //k간격만큼 멀어지므로 /k
            //,0좌표 포함 +1
            answer += (now_dis/k)+1;
        }
        return answer;
    }
}

//long 변환 신경쓰기...!!!