//set으로 풀면 시간초과
//map으로 풀어야 함
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map_1 = new HashMap<>();
        HashMap<Integer, Integer> map_2 = new HashMap<>();  
        
        for(int num_1:topping) {
            //형한테 다 넣기
            map_1.put(num_1, map_1.getOrDefault(num_1,0)+1);
        }
        
        //형한테서 하나씩 빼면서 동생한테 넣은 후 갯수 세기
        for(int num_2:topping) {
            //형한테 1개가 남은 걸 동생한테 주면 형한테서 해당 토핑 제거
            if(map_1.get(num_2) == 1) {
                map_1.remove(num_2);
            }
            
            //1개보다 많다면 -1
            else {
                map_1.put(num_2, map_1.get(num_2)-1);
            }
            
            //동생한테 넣기
            map_2.put(num_2, map_2.getOrDefault(num_2,0)+1);
            
            //갯수 비교
            if(map_1.size() == map_2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}