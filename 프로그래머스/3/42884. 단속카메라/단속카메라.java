//아이디어 구상 실패..
//1.들어오는 시점을 기준으로 내림차순 정렬
//2.들어오는 시점에 카메라 설치, 카메라가 다음 배열에 있을 경우 continue
//3.없으면 새롭게 들어오는 시점에 카메라 설치, answer++;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //배열
        Arrays.sort(routes, (o1,o2)-> o2[0]-o1[0]);
        System.out.println(Arrays.deepToString(routes));
        
        int max = routes[0][0];
        answer++;
        
        for(int i=1; i<routes.length; i++) {
            if(max>=routes[i][0] && max<=routes[i][1]) {
                //루트 사이에 카메라가 있으므로 패스
                continue;
            }
            else {
                max = routes[i][0];
                answer++;
            }
        }
        
        return answer;
    }
}