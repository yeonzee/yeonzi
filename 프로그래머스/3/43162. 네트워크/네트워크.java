import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            //방문하지 않았을 경우
            if(!visited[i]) {
                dfs(computers,i);
                //순회하고 오면 그것만큼 네트워크가 형성된 것이기 때문에 answer++;
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int i) {
        
        //시작 노드 방문처리
        visited[i] = true;
        
        for(int j=0; j<computers[0].length; j++) {
            if(i != j) {  //나 자신 무시
                if(computers[i][j] == 1 && !visited[j]) {  //연결되어 있고 방문하지 않았다면 그 노드를 기점으로 탐방
                    visited[j] = true;
                    dfs(computers, j);
                }
            }
        }
    }
}
//!visited[j] 를 넣는 이유 -> A와 B가 연결되어 있을 때 A에서 B로 갔다가 B에서 다시 A로 가는 무한 순회 발생을 피하기 위해