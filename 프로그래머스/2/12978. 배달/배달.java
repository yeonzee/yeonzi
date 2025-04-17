//최단거리 -> 다익스트라 알고즘
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N][N];
        //거리를 최솟값으로 갱신하기 위해 가장 큰 값 넣어주기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                //나 자신은 거리를 0으로 처리
                if(i==j) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 500000;
                    map[j][i] = 500000;
                }
            }
        }
        
        //road 값 넣어주기
        for(int[] r:road) {
            //이미 더 작은 값이 들어가있다면 갱신하지 말고 넘어가기
            if(map[r[0]-1][r[1]-1] < r[2]) {
                continue;
            }
            map[r[0]-1][r[1]-1] = r[2];
            map[r[1]-1][r[0]-1] = r[2];
        }
        
        //다익스트라 알고리즘
        
        //경유
        for(int i=0; i<map.length; i++) {
            //시작
            for(int j=0; j<map.length; j++) {
                //마지막
                for(int k=0; k<map.length; k++) {
                    //경유하는 것이 더 작다면 그것으로 갱신
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
        
        //k보다 작은 것
        for(int i=0; i<map.length; i++) {
            if(map[0][i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}