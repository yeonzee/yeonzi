//for문은 시간초과뜸......
//효율성을 위해 stack으로 풀어야 함
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            //스택이 비어있지 않고 조건을 만족한다면
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];  //큰 값 넣기
            }
            stack.push(i);
        }
        
        //비어있다면 -1
        for(int j=0; j<answer.length; j++) {
            if(answer[j] == 0) {
                answer[j] = -1; 
            }
        }
        
        return answer;
    }
}