//bfs
import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int idx = 0;
        
        for(String[] p:places) {
            boolean check = true;
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    //P라면
                    if(p[i].charAt(j) == 'P') {
                        //한 부분이라도 거리두기를 지키지 못했다면 0
                        if(!bfs(i,j,p)) {
                            check = false;
                            break;
                        }
                    }
                }
            }
            //거리두기를 지켰다면
            if(check) {
                answer[idx] = 1;
            }
            else {
                answer[idx] = 0;
            }
            idx++;
        }
        return answer;
    }
    
    public boolean bfs(int x, int y, String[] p) {
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            
            for(int i=0; i<4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                
                //범위를 벗어나거나 나 자신 패스
                if(next_x<0 || next_x>=5 || next_y<0 || next_y>=5 || (next_x==x && next_y==y)) {
                    continue;
                }
                
                //맨해튼 거리
                int m = Math.abs(next_x-x) + Math.abs(next_y-y);
                
                //맨해튼 거리가 2보다 작고 이동한 곳에 다른 응시자가 있으면 거리두기 실패
                if(m <= 2 && p[next_x].charAt(next_y) == 'P') {
                    return false;
                }
                //맨해튼 거리가 2보다 작고 이동한 곳이 빈자리이면 거기서부터 재탐색
                if(m < 2 && p[next_x].charAt(next_y) == 'O') {
                    q.add(new int[]{next_x, next_y});
                }
                
            }
        }
        //거리두기 지킴
        return true;
    }
}