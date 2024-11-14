import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //오름차순
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        //내림차순
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str:operations) {
            String[] temp = str.split(" ");
            String cmd = temp[0];
            int num = Integer.parseInt(temp[1]);
            
            if(cmd.equals("I")) {
                min_q.add(num);
                max_q.add(num);
            }
            
            else if(cmd.equals("D")) {
                //최솟값 삭제
                if(num == -1) {
                    max_q.remove(min_q.poll());
                }
                //최댓값 삭제
                else {
                    min_q.remove(max_q.poll());
                }
            }
        }
        
        //비어있는 경우 0
        if(max_q.isEmpty() || min_q.isEmpty()) {
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