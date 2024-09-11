import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num:tangerine) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        //value기준 내림차순 정렬
        //map은 순서를 보장하지 않는 자료구조이다
        //list로 변환하여 정렬해야 함
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2) -> map.get(o2)-map.get(o1));
        
        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            sum += map.get(list.get(i));
            answer++;
            
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}