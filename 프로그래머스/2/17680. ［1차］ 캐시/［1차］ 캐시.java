//캐시크기만큼의 배열 생성
//새로 들어가면 +5
//이미 있으면 +1
//넣기 시작한 시점부터 arr에 도시이름이 있는지 확인해야 함
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();
        
        //캐시크기가 0일 경우
        if(cacheSize == 0) {
            return cities.length*5;
        }
        
        for(int i=0; i<cities.length; i++) {
            String str = cities[i].toLowerCase();  //다 소문자로 변환
            
            if(arr.contains(str)) {  //arr에 있으면 +1
                //LRU이기 때문에 해당하는 도시 지우고 최근 도시 값으로 갱신
                arr.remove(str);
                arr.add(str);
                answer++;
            }
            
            else {  //arr에 없으면 +5
                if(arr.size() < cacheSize) {  //캐시크기보다 작다면 삭제없이 삽입
                    arr.add(str);
                    answer += 5;
                }
                else {  //캐시크기보다 크다면 삭제 후 삽입
                    arr.remove(0);
                    arr.add(str);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}