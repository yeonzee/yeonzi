import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //i는 나갈 순서, box는 들어온 순서
        int i=0;
        int box=1;
        
        while(i<order.length) {
            if(box == order[i]) {
                answer++;
                i++;
                box++;
            }
            else if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                i++;
            }
            else if(box<=order.length) {
                stack.push(box);
                box++;
            }
            else {
                break;
            }
        }
        return answer;
    }
}