//bfs
import java.util.*;
class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        
        //연결되어 있는 부분들 1로 초기화
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        //하나씩 끊어보면서 갯수 세기
        for(int i=0; i<wires.length; i++) {
            //끊기
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            
            answer = Math.min(answer, bfs(wires[i][0], n, map));
            
            //끊은 전선 다시 되돌리기
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
            
        }
        return answer;
    }
    
    public int bfs(int start, int n, int[][] map) {
        Queue<Integer> q = new LinkedList<>();
        
        //시작 넣기
        q.offer(start);
        
        //시작 방문처리
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        //나 자신 방문하면서 시작하기 때문에
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            for(int i=1; i<n+1; i++) {
                //연결되어 있고 방문하지 않았다면 다시 탐방
                if(map[temp][i] == 1 && !visited[i]) {
                    //방문 처리
                    visited[i] = true;
                    cnt++;
                    q.offer(i);
                }
            }
        }
        
        return Math.abs(n-2*cnt);
    }
}