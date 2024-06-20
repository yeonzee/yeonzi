import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            // 스택의 top이 현재 숫자보다 작거나 같으면 pop합니다.
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            // 스택이 비어 있으면 다음 큰 숫자가 없음을 의미하므로 -1을 저장합니다.
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                // 그렇지 않으면 스택의 top이 다음 큰 숫자입니다.
                answer[i] = stack.peek();
            }
            
            // 현재 숫자를 스택에 추가합니다.
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}
