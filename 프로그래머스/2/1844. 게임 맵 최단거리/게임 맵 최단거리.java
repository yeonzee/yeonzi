//최단거리는 bfs사용
//bfs, 큐
import java.util.*;
class Solution {
    
    int[] dx = {0,1,-1,0};
    int[] dy = {1,0,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1]; // 상대 팀
            
        if (answer == 0) { //상대 팀 진영에 도달하지 못한 경우
            answer = -1;
        }
        return answer;
    }
    
    //void는 리턴값 없음을 뜻함
    public void bfs(int[][]maps, int[][] visited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); //큐에 시작 정점 추가
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) { //더 나아갈 정점이 없을 때까지 반복
            int[] current = queue.poll(); //정점 하나 꺼내기
            int x = current[0];
            int y = current[1];
            
            for (int i=0; i<4 ; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                //좌표가 maps에서 벗어날 경우 다음 반복으로 넘어간다
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length-1) {
                    continue;
                }
                //아직 방문하지 않았고, 벽이 아닐 경우
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] +1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}