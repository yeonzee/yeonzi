import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //우선순위 큐 내림차순으로 정렬
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num:priorities) {
            q.add(num);
        }
        
        while(!q.isEmpty()) {
           for(int i=0; i<priorities.length; i++) {
               //우선순위대로 비교
                if(q.peek() == priorities[i]) {
                    q.poll();
                    answer++;
                    
                    //location과 같다면
                    if(i==location) {
                        return answer;
                    }

                }
            } 
        }
            
        return answer;
    }
}