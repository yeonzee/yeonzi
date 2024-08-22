import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //우선순위 큐 (오름차순)
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        //우선순위 큐 (내림차순)
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            String[] cmd = operations[i].split(" ");
            int num = Integer.parseInt(cmd[1]);
            if(cmd[0].equals("D")) {
                if(num>0) {  //최댓값 삭제
                    min_q.remove(max_q.poll());
                }
                else {  //최솟값 삭제
                    max_q.remove(min_q.poll());
                }
            }
            else {  //숫자 넣기
                min_q.add(num);
                max_q.add(num);
            }
        }
        
        if(min_q.isEmpty() || max_q.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = max_q.poll();
            answer[1] = min_q.poll();
        }
        return answer;
    }
}