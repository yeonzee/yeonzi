import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        //보조 컨테이너 벨트
        Stack<Integer> stack = new Stack<>();
        
        //트럭에 담겨야 할 박스
        int i = 0;
        //현재 박스
        int box = 1;
        while(box<=order.length) {
            //트럭에 들어가야 하는 박스
            int truck = order[i];
            
            //현재 들어온 박스가 트럭에 실을 수 있다면
            if(box == truck) {
                box++;
                i++;
                answer++;
            }
            //보조 컨테이너에 있다면
            else if(!stack.isEmpty() && stack.peek() == truck) {
                while(!stack.isEmpty() && stack.peek() == truck) {
                    stack.pop();
                    i++;
                    answer++;
                }
            }
            //트럭에 실을 수 없다면 
            else {
                stack.push(box);
                box++;
            }
        }
        
        //박스 다 넣은 뒤에도 보조 컨테이너에 실을 수 있는 게 있을 수 있음
        while (!stack.isEmpty() && stack.peek() == order[i]) {
            stack.pop();
            i++;
            answer++;
        }
        
        return answer;
    }
}