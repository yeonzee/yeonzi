import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            else if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
            }
            else {
                return false;  //여기서 바로 반환해줘야함 (answer = false 하면 안됨) 밑에서 answer가 갱신되기 때문에
            }
        }
        
        if(stack.isEmpty()) {
            answer = true;
        }
        else {
            answer = false;
        }

        return answer;
    }
}