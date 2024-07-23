/*
1. n을 중심으로 앞에 있으면 up 뒤에 있으면 down
2. 정방향or역방향으로 움직이는 경우와 A를 만나면서 꺾이는 경우의 값 중 최솟값 구하기
*/
import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        //좌우로 움직이는 것
        //쭉 직진하는 것을 기준으로 하기 때문에
        int move = name.length()-1;
        
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            //1번 조건
            answer += Math.min(c-'A', 'Z'-c+1);
            
            //2번 조건
            int index = i+1;
            //A가 여러개일 수도 있기 때문에
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            //정주행, 역주행 하는 것과 A를 기점으로 돌아가는 것 중 더 짧은 것 고르기
            move = Math.min(move, i*2 + name.length()-index);
            
            //처음부터 뒤에서 구해주는 게 더 빠른 것도 구해주기 ex) BBBBAABB
            move = Math.min(move,(name.length()-index)*2 + i);
            
        }
        return answer+move;
    }
}