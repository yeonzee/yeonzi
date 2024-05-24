import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            // 스택이 비어있지 않고, 현재 숫자가 스택의 맨 위 숫자와 같으면 스택에서 제거하지 않음
            if (!stack.isEmpty() && stack.peek() == num) {
                continue;
            }
            else {
                stack.push(num);
            }
        }
        
        //거꾸로 쌓이는 거 주의!
        int[] answer = new int[stack.size()];
        for (int i =stack.size()-1;i>=0;i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}