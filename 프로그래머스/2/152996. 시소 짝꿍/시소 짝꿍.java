//*1, *2/3, *3/4, *2/4
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        HashMap<Double, Integer> map = new HashMap<>();
        
        for(int w:weights) {
            //실수로 나눠줘야해서 소수점으로 계산
            double n1 = w*1.0;
            double n2 = w*(2.0/3.0);
            double n3 = w*(3.0/4.0);
            double n4 = w*(2.0/4.0);
            
            if(map.containsKey(n1)) {
                answer += map.get(n1);
            }
            if(map.containsKey(n2)) {
                answer += map.get(n2);
            }
            if(map.containsKey(n3)) {
                answer += map.get(n3);
            }
            if(map.containsKey(n4)) {
                answer += map.get(n4);
            }
            
            map.put(n1, map.getOrDefault(n1,0)+1);
        }
        
        return answer;
    }
}