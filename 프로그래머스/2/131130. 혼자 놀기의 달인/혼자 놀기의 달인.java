/* index와 카드번호 비교
boolean 함수로 열었던 상자인지 확인
list에 상자 갯수를 담고 내림차순 정렬 후 상위 2개 곱하기
*/
import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 1;
    
        //그룹 별 총 갯수를 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        //방문 확인
        boolean[] check = new boolean[cards.length];
        
        for(int i=0; i<cards.length; i++) {
            int count = 0;
            while(true) {
                if(check[i] == true) {
                    break;
                }
                check[i] = true;
                i = cards[i]-1;
                count++;
            }
            list.add(count);
        }
        
        //list 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        //0일 경우 제외
        if(list.get(0) == 0) {
            answer = 0;
            return answer;
        }
        
        for(int j=0; j<2; j++) {
            answer *= list.get(j);
        }
        
        return answer;
    }
}