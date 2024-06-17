import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length;i++) {
            int x=1;
            while(true) {
                if((speeds[i]*x) + progresses[i] >= 100) {
                    break;
                }
                else {
                    x++;
                }
            }
            queue.add(x);
        }
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentDay = queue.poll();
            int count = 1;
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}