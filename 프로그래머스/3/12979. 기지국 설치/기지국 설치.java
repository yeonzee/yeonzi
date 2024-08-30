//이게 더 좋은 방법인듯
//첫번째 아파트부터 조사하여 하나씩 늘려간다 (while을 통해)
//w*2+1 -> 전파 범위
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int st = 0;
        int apt = 1;  //첫번째 아파트부터 조사
        
        while (apt <= n) {
            //현재 기지국으로 처리 가능한지 먼저!!! 확인함
            if(st<stations.length && stations[st]-w <= apt) {  
                apt = stations[st] + w + 1;  //처리 가능하다면 처리한 다음 아파트로 갱신
                st++;
            }
            else {  //추가 기지국 필요
                answer++;
                apt += 2*w+1;
            }
        }

        return answer;
    }
}