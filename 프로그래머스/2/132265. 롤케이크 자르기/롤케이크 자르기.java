//for문을 이용한 set은 시간초과
//map 사용
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //형
        HashMap<Integer, Integer> map_1 = new HashMap<>();
        
        //동생
        HashMap<Integer, Integer> map_2 = new HashMap<>();
        
        //형한테 몰빵
        for(int t:topping) {
            map_1.put(t, map_1.getOrDefault(t,0)+1);
        }
        
        //동생이 하나씩 뺏기
        for(int t:topping) {
            
            //만약 1개 남은걸 준다면 형한테서 해당 토핑을 사라짐
            if(map_1.get(t) == 1) {
                map_2.put(t, map_2.getOrDefault(t,0)+1);
                map_1.remove(t);
            }
            else {
                map_2.put(t, map_2.getOrDefault(t,0)+1);    //동생한테 추가
                map_1.put(t, map_1.getOrDefault(t,0)-1);    //형한테서 빼기
            }
            
            //형과 동생의 토핑 갯수가 같아진다면
            if(map_1.size() == map_2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}