//map과 그 map을 복사하여 비교
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            map.put(want[i],number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++) {
            //map 복사
            HashMap<String, Integer> now_map = new HashMap<>(map);
            
            for(int j=i; j<10+i; j++) {
                //하나씩 빼기
                if(now_map.containsKey(discount[j])) {
                    now_map.put(discount[j], now_map.get(discount[j])-1);
                }
            }
            
            
            //복사한 map에서 0보다 큰게 있다면 못산게 있다는 뜻 = 실패
            boolean check = true;
            for(int k=0; k<want.length; k++) {
                if(now_map.get(want[k]) > 0) {
                    check = false;
                    break;
                    
                } 
            }
            
            if(check) {
                    answer++;
                }
        }
        
        
        return answer;
    }
}