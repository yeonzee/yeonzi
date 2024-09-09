//어떠한 방법을 써도 풀리지 않음
//투포인터 방법
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length-1;
        
        int count = 0;
        
        while(true) {
            if(i > j) {
                break;
            }
            
            int sum = 0;
            sum = people[i] + people[j];
            
            if(sum > limit) {  //구명보트 제한을 넘는다면 뒤에 한 사람만 처리
                j--;
                count++;
            }
            else {  //구명보트에 2명 채워서 처리
                i++;
                j--;
                count++;
            }
        }
        return count;
    }
}