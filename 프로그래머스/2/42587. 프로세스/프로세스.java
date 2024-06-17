import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //우선순위 큐는 작은 것부터 나오므로 역순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        //큐에 넣기
        for (int num:priorities) {
            queue.offer(num);
        }
        
        while(!queue.isEmpty()) {
            for (int i=0;i<priorities.length;i++) {
                //큐의 가장 앞에 있는 값과 priorites[i]의 값이 같다면
                if(queue.peek() == priorities[i]) {
                    //삭제
                    queue.poll();
                    answer++;
                    
                    //내가 찾던 위치와 같다면 return
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}