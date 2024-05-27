//우선순위 큐 사용
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        //우선순위 큐는 작은 것을 반환
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for (int i=0;i<score.length;i++) {
            priorityQueue.add(score[i]);
            
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
                //첫번째 값 반환한 후 제거!! 비어있으면 null반환
            }
            //첫번째 값 반환
            answer[i] = priorityQueue.peek();
        }
        return answer;
    }
}