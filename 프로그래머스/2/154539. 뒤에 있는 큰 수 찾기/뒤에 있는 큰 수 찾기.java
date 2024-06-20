//시간효율성을 위해 스택 사용
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<numbers.length;i++) {
            //빈 스택이 아니고 스택의 peek값보다 numbers[i]의 값이 더 클때
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        for (int j=0;j<numbers.length;j++) {
            if(answer[j] == 0) {
                answer[j] = -1;
            }
        }
        return answer;
    }
}