import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int apt = 1;  //아파트 1부터 탐방
        int st = 0;   //stations의 index확인
        
        while(apt<=n) {
            //기지국이 이미 설치되었는지 확인
            if(st<stations.length && stations[st]-w <= apt) {
                apt = stations[st]+w+1;
                st++;
            }
            
            //새로운 기지국 설치
            else {
                answer++;
                apt += 2*w+1;
            }
        }

        return answer;
    }
}