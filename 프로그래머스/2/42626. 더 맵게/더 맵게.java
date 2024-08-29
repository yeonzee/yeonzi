//우선순위 큐 사용
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        while(true) {
            if(q.size() == 1 && q.peek() < K) {  //스코빌 지수를 만들 수 없는 경우
                return -1;
            }
        
            if(q.peek() < K) {  //시작부터 모든 수가 K보다 큰 경우때문에 if절 사용
                int a = q.poll();
                int b = q.poll();

                int scv = a+(b*2);

                q.add(scv);

                answer++;
            }
            else {
                break;
            }
        }
        
        return answer;
    }
}