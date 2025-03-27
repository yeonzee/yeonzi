//이중 for문을 활용한 set은 시간 초과
//map 사용
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //형 토핑 map
        HashMap<Integer, Integer> map_1 = new HashMap<>();
        
        //동생 토핑 map
        HashMap<Integer, Integer> map_2 = new HashMap<>();
        
        //동생한테 몰아주기
        for(int n:topping) {
            map_2.put(n,map_2.getOrDefault(n,0)+1);
        }
        
        //형이 하나씩 뺏기
        for(int n:topping) {
            
            //동생한테 1개 남은 걸 형한테 주면 동생한테서 토핑 제거
            if(map_2.get(n)==1) {
                map_2.remove(n);
            }
            else {
                //동생 토핑 뺏기
                map_2.put(n,map_2.getOrDefault(n,0)-1);
            }
            
            //형한테 토핑 추가
            map_1.put(n,map_1.getOrDefault(n,0)+1);
            
            //형이랑 동생이랑 토핑 갯수가 같다면
            if(map_1.size() == map_2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}