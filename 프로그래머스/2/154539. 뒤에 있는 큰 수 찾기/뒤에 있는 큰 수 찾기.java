//100만이래서 이중 for문 사용하면 시간 초과
//stack 사용
//뭔말인지도 몰겠음
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            
            //stack이 비어있지 않고
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        //빈 곳에 -1 넣어주기
        for(int j=0; j<numbers.length; j++) {
            if(answer[j] == 0) {
                answer[j] = -1;
            }
        }
        return answer;
    }
}