import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //나가는 지점을 기준으로 오름차순
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);
        // for(int[] a:routes) {
        //     System.out.println(Arrays.toString(a));
        // }
        
        //나가는 지점을 기준으로 카메라 설치
        int max = routes[0][1];
        answer++;
        
        for(int i=1; i<routes.length; i++) {
            if(max>=routes[i][0] && max<=routes[i][1]) {  //이미 카메라가 있다는 것
                continue;
            }
            else {
                max = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}