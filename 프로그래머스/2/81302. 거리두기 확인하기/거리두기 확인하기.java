//1. p 주위에 p
//2. p옆에 o라면 o의 위치를 중심으로 주위에 p가 있는 지 확인
import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        
        for(int i=0; i<places.length; i++) {
            String[] place = places[i];
            boolean check = false;
            for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if(place[j].charAt(k) == 'P') {
                        if(bfs(place, j,k)) {
                            //true면 거리두기 지키지 않음
                            check = true;
                        }
                    }
                }
            }
            answer[i] = check? 0:1;
        }
        return answer;
    }
    
    public boolean bfs(String[] p, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i=0; i<4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                
                //탐색 범위 벗어나면 + 최초 출발점을 탐색에서 제외!!
                if(nx<0 || ny<0 || nx>=5 || ny>=5 || (nx==x && ny==y)) {
                    continue;
                }
                
                //맨해튼거리
                int m = Math.abs(x-nx) + Math.abs(y-ny);
                
                //p가 맨해튼거리에 있다면
                if(p[nx].charAt(ny) == 'P') {
                    return true;
                }
                
                //p 옆에 o가 있다면
                //o를 p로 옮기더라도 맨해튼 거리 안에 있어야 함
                else if(p[nx].charAt(ny) == 'O' && m<2) {
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return false;
    }
}