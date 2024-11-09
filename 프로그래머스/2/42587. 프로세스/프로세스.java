import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //큰 수부터 꺼내기 위해 우선순위큐를 내림차순
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num:priorities) {
            q.offer(num);
        }
        
        while(!q.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                //큐의 가장 앞에 있는 값과 같다면
                if(q.peek() == priorities[i]) {
                    q.poll();
                    answer++;
                    
                    //location과 일치하다면
                    if(i==location) {
                        return answer;
                    }
                }
                
            }
        }
        return answer;
    }
}