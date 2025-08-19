//스택 사용
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        
        //스택이 비어있으면 1
        if(stack.isEmpty()) {
            answer = 1;
        }
        else {
            answer = 0;
        }
        

        return answer;
    }
}