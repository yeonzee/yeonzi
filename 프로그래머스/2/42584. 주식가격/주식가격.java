import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;
        
        for (int i=0; i<prices.length;i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int top = stack.pop();
                answer[top] = i-top;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int topIndex = stack.pop();
            answer[topIndex] = len-1-topIndex;
        }
        return answer;
    }
}