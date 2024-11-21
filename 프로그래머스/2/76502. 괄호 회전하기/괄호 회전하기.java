//스택
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i) + s.substring(0,i);
            Stack<Character> stack = new Stack<>();
            
            //시작이 닫힌 괄호일 경우 올바르지 않은 괄호식
            if(str.charAt(0) == ']' || str.charAt(0) == '}' || str.charAt(0) == ')') {
                continue;
            }
            
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                
                //열린괄호
                if(c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                }
                //올바른 괄호
                else if(!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if(!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            }
            
            //스택이 비어있으면 올바른 괄호
            if(stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}