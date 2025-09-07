import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>(); //초기화
            
            //시작이 닫힌 괄호이면 x
            if(s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}') {
                continue;
            }
            
            for(int j=i; j<s.length()+i; j++) {
                //열림이라면 스택에 넣고 다음 확인하기
                if(s.charAt(j%s.length()) == '(' || s.charAt(j%s.length()) == '[' || s.charAt(j%s.length()) == '{') {
                    stack.push(s.charAt(j%s.length()));
                }

                //닫힘이라면 스택에 괄호 쌍이 들어가 있는지 확인
                else {
                    //쌍에 맞는 괄호인지 확인
                    if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(j%s.length()) == ')') {
                        stack.pop();
                    }
                    else if(!stack.isEmpty() && stack.peek() == '[' && s.charAt(j%s.length()) == ']') {
                        stack.pop();
                    }
                    else if(!stack.isEmpty() && stack.peek() == '{' && s.charAt(j%s.length()) == '}') {
                        stack.pop();
                    }
                }
            }
            //스택이 비어있다면 올바른 괄호 문자열
            if(stack.isEmpty()) {
                answer++;
            }
        }
        return answer;

    }

}