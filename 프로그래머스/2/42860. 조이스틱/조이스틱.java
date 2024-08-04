//n을 중심으로 앞에 있으면 up, 뒤에 있으면 down
//A를 만나면 역주행
import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length();
        
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            
            //더 작은 값 넣어주기
            answer += Math.min(c-'A','Z'-c+1);
            
            //역주행 조건
            int index = i+1;
            //A가 여러개일 수도 있기 때문에
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            //정주행하는 것과 A를 기점으로 돌아가는 것 중 더 최솟값 고르기
            move = Math.min(move,i*2 + name.length()-index);
            
            //이건 뭐지
            //애초에 뒤에서 시작하는 것이 더 빠른 경우도 구해주기 BBBBAABB
            move = Math.min(move,(name.length()-index)*2 + i);
            
        }
        return answer+move; 
    }
}