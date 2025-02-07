//최단거리 bfs
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    static int[][] visited;
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        //도달하지 못하면 -1
        if(visited[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }
        
        return visited[maps.length-1][maps[0].length-1];
    }
    
    public void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>(); 
        //시작 넣기
        q.offer(new int[] {0,0});
        
        //시작 방문 처리
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위를 벗어나거나 벽이거나 이미 방문했다면 continue
                if(nx<0 || nx>maps.length-1 || ny<0 || ny>maps[0].length-1 || maps[nx][ny] == 0 || visited[nx][ny] != 0) {
                    continue;
                }
                else {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[] {nx,ny});
                }
                
            }
        }
    }
}