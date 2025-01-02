//이중for문 시간초과
//stack 사용
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        //비어있다면 -1
        for(int j=0; j<numbers.length; j++) {
            if(answer[j] == 0) {
                answer[j] = -1;
            }
        }
        
        return answer;
    }
}