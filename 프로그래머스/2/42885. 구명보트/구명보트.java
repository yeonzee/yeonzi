//정렬한 후 앞 뒤로 구명보트에 담기
//문제를 제대로 읽자 한 번에 최대 2명 탈 수 있음
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
    
        int i = 0;
        int j = people.length-1;
        
        while(true) {
            //종료조건
            if(i>j) {
                break;
            }
            
            int sum = people[i] + people[j];
            
            if(sum <= limit) {
                i++;
                j--;
            }
            else {
                j--;
            }
            answer++;
        }
        return answer;
    }
}