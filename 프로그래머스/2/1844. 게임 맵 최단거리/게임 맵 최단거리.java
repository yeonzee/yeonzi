import java.util.*;
class Solution {
    //동서남북
    static int[] move_x = {-1,1,0,0};
    static int[] move_y = {0,0,-1,1};
    static int[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(visited, maps);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        //상대 팀 진영에 도착하지 못하는 경우
        if(answer == 0) {
            return -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] visited, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        //시작점 넣기
        q.offer(new int[]{0,0});
        
        //시작
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            for(int i=0; i<4; i++) {
                int now_x = temp[0] + move_x[i];
                int now_y = temp[1] + move_y[i];
                
                //조건을 벗어났을 때 무시
                if(now_x<0 || now_x>maps.length-1 || now_y<0 || now_y>maps[0].length-1) {
                    continue;
                }
                
                //방문 안했고 1이라면
                if(visited[now_x][now_y]==0 && maps[now_x][now_y]==1) {
                    visited[now_x][now_y] = visited[temp[0]][temp[1]]+1;
                    q.add(new int[]{now_x, now_y});
                }
            }
        }
    }
}