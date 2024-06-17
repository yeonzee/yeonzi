/*
LRU는 가장 최근에 것만 사용
새로운 값이 들어올 경우 가장 오래된 값 삭제 후 삽입
캐시 안에 해당 값이 있는 경우 +1
캐시 안에 해당 값이 없는 경우 +5
ArrayList 사용
*/
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        
        //캐시크기가 0인 경우
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i=0;i<cities.length;i++) {
            //캐시에 이미 해당 값이 있다면
            String str = cities[i].toLowerCase(); //대소문자 구분x
            if (list.contains(str)) {
                //해당 도시 지우고 최근 값으로 갱신
                list.remove(str);
                list.add(str);
                answer += 1;
            }
            //캐시에 해당 값이 없다면
            else {
                //꽉 찼다면
                if (list.size() == cacheSize) {
                    //가장 오래된 값 지우기
                    list.remove(0);
                    list.add(str);
                    answer += 5;
                }
                //비었다면
                else {
                    list.add(str);
                    answer += 5;
                }
                
            }
            
        }
        return answer;
    }
}