/*
너무 어려워서 눈물이 찔끔 나네요
최단거리는 bfs 사용
큐를 이용하여 다음에 갈 진영을 저장하기
*/
import java.util.*;
class Solution {
    
    //x축 y축으로 옮겨갈 수 있는 배열
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1]; //상대 팀 마지막 진영
        
        if (answer == 0) {
            return -1;
        }
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        
        //큐는 현재 진영에서 다음 넘어갈 수 있는 진영들을 저장해놓음
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0}); //시작
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i=0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                //좌표가 maps를 벗어난 경우
                if (nx<0 || nx>maps.length-1 || ny<0 || ny >maps[0].length-1) {
                    continue;
                    //for문 다시 시행
                }
                
                //방문했던 곳이 아니고 벽이 아니라면
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}