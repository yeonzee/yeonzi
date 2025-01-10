//bfs
import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<places.length; i++) {
            String[] a = places[i];
            boolean check = true;
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(a[j].charAt(k) == 'P') {
                        if(!bfs(a, j, k)) {
                            //거리두기를 지키지 않은 경우
                            check = false;
                        }
                    }
                }
            }
            answer[i] = check? 1:0;
        }
        return answer;
    }
    public boolean bfs(String[] a, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];
                
                //탐색 범위 벗어남 + 나 자신 무시
                if(nx<0 || ny<0 || nx>=5 || ny>=5 || (nx==x && ny==y)) {
                    continue;
                }
                
                //맨해튼 거리
                int m = Math.abs(nx-x) + Math.abs(ny-y);
                
                //이동한 곳이 P이고 맨해튼 거리가 2보다 작거나 같으면 거리두기 실패
                if(a[nx].charAt(ny) == 'P' && m<=2) {
                    return false;
                }
                //이동한 곳이 빈자리이고 맨해튼 거리가 2보다 작으면 그 곳을 기준으로 P가 있는지 재탐색
                if(a[nx].charAt(ny) == 'O' && m<2) {
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        //거리두기 지킴
        return true;
    }
}