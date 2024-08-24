//dfs
import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        //방문 여부 확인
        visited = new boolean[n+1];
        
        for(int i=0; i<computers.length; i++) {
            //방문하지 않는 노드에 대해서만 dfs
            if(!visited[i]) {
                dfs(i, computers);
                //dfs에서 리턴돼서 오면 네트워크 하나가 생성되었다는 뜻이므로 answer++
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers) {
        
        visited[node] = true;
        for(int i=0; i<computers.length; i++) {
            //연결되어있고 방문하지 않았다면
            if(computers[node][i] == 1 && !visited[i]) {
                //방문처리
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}