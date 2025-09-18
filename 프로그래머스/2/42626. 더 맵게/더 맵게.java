//무조건 제일 작은 수를 스코빌 지수와 비교해야 하므로 우선순위 큐 사용
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int s:scoville) {
            q.add(s);
        }
        
        
        while(true) {
            //1개밖에 안남았는데 그게 K보다 작다면 스코빌 지수를 만들 수 없음  = -1
            if(q.size() == 1 && q.peek() < K) {
                return -1;
            }
            
            //스코빌 지수보다 작은 수가 있다면
            if(q.peek() < K) {
                int n_1 = q.poll();
                int n_2 = q.poll();
                
                int n = n_1 + (n_2 * 2);
                
                q.add(n);
                answer++;
            }
            //제일 작은 수가 스코빌 지수보다 크다면 조건 만족 = break
            else {
                break;
            }
        }
        
        
        return answer;
    }
}