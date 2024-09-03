//최단거리 = bfs
import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = 0;
    static int[][] visited;
    public int solution(int[][] maps) {
        
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        if(visited[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }
        
        return visited[maps.length-1][maps[0].length-1];
    }
    
    public void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            
            for(int i=0; i<4; i++) {
                int next_x = now_x+dx[i];
                int next_y = now_y+dy[i];
                
                //범위를 벗어나면 무시
                if(next_x < 0 || next_x >= maps.length || next_y < 0 || next_y >= maps[0].length) {
                    continue;
                }
                
                //방문하지 않았고 갈 수 있는 길이라면
                if(visited[next_x][next_y] == 0 && maps[next_x][next_y] == 1) {
                    visited[next_x][next_y] = visited[now_x][now_y]+1;  
                    q.add(new int[]{next_x, next_y});
                }
            }
        }
    }
}