//map에 넣은 후 많은 순부터 빼기?
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t:tangerine) {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        
        //System.out.print(map);
        
        //정렬
        //map으로 정렬할 수 없으므로 list로 변환한다
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        
        //System.out.print(list);
        
        int sum=0;
        
        for(int i=0; i<list.size(); i++) {
            sum += map.get(list.get(i));
            answer++; 
            
            //종료조건
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}