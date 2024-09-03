//StringBuilder와 delete는 효율성이 떨어진다 -> stack 사용
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            //스택이 비어있지 않고 조건을 만족한다면
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}