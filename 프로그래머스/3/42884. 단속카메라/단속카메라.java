//나가는 시점에 카메라 설치
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //나가는 시점으로 오름차순 정렬
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);

        int max = routes[0][1];  //첫번째 나가는 시점
        answer++;  //그 시점에 카메라 설치
        
        for(int i=1; i<routes.length; i++) {
            if(max <= routes[i][1] && max >= routes[i][0]) {  //구간 사이에 있다면 무시
                continue;
            }
            else {  //구간 사이에 없다면 카메라 갱신
                max = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}