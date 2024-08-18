//최단거리니깐 bfs
//2배 하는 거 이해 못해서 구글링함
import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[][] rec;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int answer = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        rec = new int[101][101];
        visited = new boolean[101][101];
        
        //2배 해서 표 그리기
        for(int i=0; i<rectangle.length; i++) {
            draw(rectangle[i][0]*2,rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2);
        }
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    
    public void draw(int x1, int y1, int x2, int y2) {
        for(int j=x1; j<=x2; j++) {
            for(int k=y1; k<=y2; k++) {
                //테두리에서만 움직이기 위해
                //만약 경계선에 걸처져 있으면 2
                if(j==x1||j==x2||k==y1||k==y2) {
                    //1이 아니라면
                    if(rec[j][k] != 1) {
                        rec[j][k] = 2;
                    }
                }
                else {
                    rec[j][k] = 1;
                }
            }
        }
    }
    
    public int bfs(int x, int y, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            int count = temp[2];
            
            //종료조건
            if(now_x == itemX && now_y == itemY) {
                answer = count/2;
                return answer;
            }
            
            for(int i=0; i<4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                
                //범위를 벗어나면 무시
                if(next_x<0 || next_x>rec.length-1||next_y<0||next_y>rec[0].length-1) {
                    continue;
                }
                
                //이미 방문했거나 2가 아닌 경우(테두리가 아니므로) 무시
                if(visited[next_x][next_y] || rec[next_x][next_y] != 2) {
                    continue;
                }
                
                //갈 수 있다면
                //방문처리
                visited[next_x][next_y] = true;
                q.add(new int[]{next_x, next_y, count+1});
            }
        }
        return 0;
    }
}