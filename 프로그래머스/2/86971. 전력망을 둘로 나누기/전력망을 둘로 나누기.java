//bfs
import java.util.*;
class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        
        //연결되어 있는 것들은 1로 초기화
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i=0; i<wires.length; i++) {
            //끊어보기
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            
            answer = Math.min(answer,bfs(n, wires[i][0]));
            
            //다른 노드를 알아보기 위해 다시 연결
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int start) {
        //방문 확인
        boolean[] visited = new boolean[n+1];
        
        //일단 나 자신은 방문하고 시작하므로 1
        int cnt = 1;
        
        //나 자신 방문 처리
        visited[start] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int point = q.poll();
            
            for(int i=1; i<=n; i++) {
                if(!visited[i] && map[point][i] == 1) {  //방문하지 않았고 연결되어 있다면
                    cnt++;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}