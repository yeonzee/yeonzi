import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(visited, maps);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        //도달할 방법이 없을 때
        if(answer == 0) {
            return -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] visited, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {0,0});
        
        //시작
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int k=0; k<4; k++) {
                int nextx = x+dx[k];
                int nexty = y+dy[k];
                
                //조건을 벗어날 때
                if(nextx<0 || nexty<0 || nextx>=maps.length || nexty>=maps[0].length) {
                    continue;
                }
                //방문 안했고 길이 있다면
                if(visited[nextx][nexty] == 0 && maps[nextx][nexty] == 1) {
                    visited[nextx][nexty] = visited[x][y]+1;
                    queue.add(new int[]{nextx, nexty});
                }
            }
        }
    }
}