//사람들 아이디어 쩐다
//우선순위 큐 사용
//제곱 값이 작기 위해서는 작은 값만 남겨야 한다
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        //큰 순으로 정렬하여 일의 시간이 긴 시간부터 처리한다
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++) {
            q.offer(works[i]);
        }
        
        //남은 시간 다 쓸때까지 반복
        while(n>0) {
            int time = q.poll();
            //남은 작업량이 없다면 피로도는 0
            if(time == 0) {
                break;
            }
            time--;
            q.offer(time);
            n--;
        }
        
        int size = q.size();
        for(int i=0; i<size; i++) {
            int a = q.poll();
            answer += a*a;
        }
        
        return answer;
    }
}