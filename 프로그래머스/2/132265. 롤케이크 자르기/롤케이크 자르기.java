/*
중복이 없다 생각하여 set로 풀었더니 시간오류 이슈
map으로 풀어야 함
*/
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = -0;
        
        
        HashMap<Integer, Integer> map_1 = new HashMap<>(); //형
        HashMap<Integer, Integer> map_2 = new HashMap<>(); //동생
        
        //형에 다 넣고 빼가면서 계산
        for (int num:topping) {
            map_1.put(num, map_1.getOrDefault(num,0)+1);
        }
        
        for (int n:topping) {
            //동생에 넣기
            map_2.put(n, map_2.getOrDefault(n,0)+1);
            
            if (map_1.get(n)-1 == 0) {
                map_1.remove(n);
            }
            else {
                map_1.put(n, map_1.get(n)-1);
            }
            
            if (map_1.size() == map_2.size()) {
                answer++;
            }
        }
        return answer;
    }
}