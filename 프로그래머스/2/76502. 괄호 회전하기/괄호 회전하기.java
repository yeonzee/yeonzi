//스택
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i) + s.substring(0,i);
            
            //시작이 닫힌 괄호이면 x
            if(str.charAt(0) == ']' || str.charAt(0) == ')' || str.charAt(0) == '}') {
                continue;
            }
            
            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            
            for(int j=1; j<str.length(); j++) {
                
                //열린 괄호
                if(str.charAt(j) == '(' || str.charAt(j) == '[' || str.charAt(j) == '{') {
                    stack.push(str.charAt(j));
                }
                
                //올바른 괄호
                else if(!stack.isEmpty() && stack.peek() == '(' && str.charAt(j) == ')') {
                   stack.pop(); 
                }
                else if(!stack.isEmpty() && stack.peek() == '{' && str.charAt(j) == '}') {
                   stack.pop(); 
                }
                else if(!stack.isEmpty() && stack.peek() == '[' && str.charAt(j) == ']') {
                   stack.pop(); 
                }
            }
            
            //stack이 비어있다면 올바른 괄호 문자열
            if(stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}