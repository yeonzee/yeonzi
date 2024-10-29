//중복을 허용하지 않는 set 2개 만들기
//라고 생각했지만 시간 이슈 생기네....
//map으로 풀기

import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map_1 = new HashMap<>();
        HashMap<Integer, Integer> map_2 = new HashMap<>();
        
        //형한테 몰아서 넣기
        for(int num:topping) {
            map_1.put(num, map_1.getOrDefault(num,0)+1);
        }
        
        //동생한테 넣고 형한테 빼가면서 갯수 확인하기
        for(int n:topping) {
            map_2.put(n, map_2.getOrDefault(n,0)+1);
        
            //map_1.get(n)-1이 0개라면 1개의 토핑이 남아있다는 뜻 -> 동생한테 줬기 때문에 형한테서 삭제해야 함
            if(map_1.get(n)-1 == 0) {
                map_1.remove(n);
            }
            
            //토핑의 갯수가 1개 이상인 경우
            //동생한테 들고갔기 때문에 형한테서 -1
            else {
                map_1.put(n,map_1.get(n)-1);
            }
            
            //형이랑 동생 갯수 확인
            if(map_1.size() == map_2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}