//최단거리(한 정점에서만 최단거리를 구하므로) -> 다익스트라 알고리즘
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //거리에 최솟값을 넣기 위해 모든 거리를 최댓값으로 초기화해서 만들어준다
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                //나 자신은 0으로 초기화
                if(i==j) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 500000;
                    map[j][i] = 500000;
                }
            }
        }
        
        //road의 값 넣어준다
        for(int[] r:road) {
            //더 작은 수가 있으면 건너뛰기
            if(map[r[0]-1][r[1]-1] < r[2]) {
                continue;
            }            
            map[r[0]-1][r[1]-1] = r[2];
            map[r[1]-1][r[0]-1] = r[2];
        }
        
        //다익스트라 알고리즘
        
        //중간에 경유
        for(int i=0; i<map.length; i++) {
            //시작
            for(int j=0; j<map.length; j++) {
                //마지막
                for(int k=0; k<map.length; k++) {
                    //만약 중간에 경유하는 경우의 값이 더 작다면 갱신
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
        
        //K보다 작은 값 추출
        for(int i=0; i<map.length; i++) {
            if(map[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}