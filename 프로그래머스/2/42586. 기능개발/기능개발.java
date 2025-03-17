import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            if((100-progresses[i]) % speeds[i] == 0) {
                q.add(((100-progresses[i]) / speeds[i]));
            }
            else {
                q.add(((100-progresses[i]) / speeds[i])+1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && temp >= q.peek()) {
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++) {
            answer[j] = list.get(j);
        }
       
        return answer;
    }
}