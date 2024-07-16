import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        //노드 순회
        for(int i=0; i<n; i++) {
            //아직 방문하지 않은 노드만
            if(!visited[i]) {
                //dfs
                dfs(computers, i, visited);
                //dfs가 돌고 return되면 네트워크 하나 생성되었다는 뜻
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int node, boolean[] visited) {
        //시작하므로 방문 처리
        visited[node] = true;
        
        for(int j=0; j<computers.length; j++) {
            //연결되어있고, 아직 방문하지 않았다면
            if(computers[node][j] == 1 && !visited[j]){
                //j를 node로 변경하여 재귀호출
                dfs(computers, j, visited);
            }
        }
    }
}