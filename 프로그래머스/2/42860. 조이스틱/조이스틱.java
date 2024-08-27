import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length();
        
        for(int i=0; i<name.length(); i++) {
            char now = name.charAt(i);
            
            //더 작은 값 넣어주기
            answer += Math.min(now-'A', 'Z'-now+1);
            
            //역주행
            int index = i+1;
            //A가 여러개일 수도 있기 때문에
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            //직직하는 것과 A가 끝난 시점에서 역주행하는 것 중 짧은 것 고르기 ex)BBBAAAAC
            move = Math.min(move, i*2 + name.length()-index);
            
            //이건 잘 모르겠음
            //애초에 뒤에서 시작하는 것이 더 빠른 경우도 구해주기
            move = Math.min(move, (name.length()-index)*2 + i);
        }
        return answer+move;
    }
}