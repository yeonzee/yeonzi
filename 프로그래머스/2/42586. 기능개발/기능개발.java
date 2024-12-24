import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            //나누어 떨어지는 경우
            if((100-progresses[i])%speeds[i] == 0) {
                q.offer((100-progresses[i])/speeds[i]);
            }
            else {
                q.offer(((100-progresses[i])/speeds[i])+1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            int num = 1;
            //q가 비었는지 먼저 확인해야함 = 비교하기전에 큐가 비어있는지 먼저 확인해야 null오류 안남
            while(!q.isEmpty() && temp >= q.peek()) {
                num++;
                q.poll();
            }
            list.add(num);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}