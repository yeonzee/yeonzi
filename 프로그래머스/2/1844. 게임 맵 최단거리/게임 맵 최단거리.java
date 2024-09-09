//최단거리 bfs
import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        if(visited[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }
        
        return visited[maps.length-1][maps[0].length-1];
    }
    
    public void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});  //시작
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            
            for(int i=0; i<4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                
                //무시: 범위 벗어남, 갈 수 없는 길임, 이미 방문했음
                if(next_x < 0 || next_x > maps.length-1 || next_y < 0 || next_y > maps[0].length-1 || maps[next_x][next_y] == 0 || visited[next_x][next_y] != 0) {
                    continue;
                }
                else {
                    visited[next_x][next_y] = visited[now_x][now_y] + 1;
                    q.add(new int[] {next_x, next_y});
                }
                
            }
        }
    }
}