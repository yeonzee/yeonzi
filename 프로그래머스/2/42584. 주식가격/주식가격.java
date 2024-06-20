import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택
        
        // 배열을 순회하면서 각 시점의 가격에 대해 처리
        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않고, 현재 가격이 스택의 top 가격보다 작을 때
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int topIndex = stack.pop();
                answer[topIndex] = i - topIndex; // 가격이 떨어지지 않은 기간을 계산
            }
            // 현재 시점의 인덱스를 스택에 추가
            stack.push(i);
        }
        
        // 스택에 남아 있는 시점들은 끝까지 가격이 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            answer[topIndex] = n - 1 - topIndex; // 끝까지 가격이 떨어지지 않은 기간
        }
        
        return answer;
    }
}
