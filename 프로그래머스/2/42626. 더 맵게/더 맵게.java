//우선순위큐 사용
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        //q에 넣기
        for(int num:scoville) {
            q.offer(num);
        }
         
        while(true) {
            if(q.size()==1 && q.peek() < K) {
                return -1;
            }
            
            if(q.peek() < K) {
                int num_1 = q.poll();
                int num_2 = q.poll();

                int sc = num_1 + (num_2*2);

                q.offer(sc);
                answer++;
            }
            
            else {
                break;
            }
            
        }
        
        return answer;
    }
}