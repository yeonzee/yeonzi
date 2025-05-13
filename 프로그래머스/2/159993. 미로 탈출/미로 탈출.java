//bfs
//first: 레버까지 가기
//second: 출구까지 가기
import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static String[][] map;
    static int[] start;
    static int[] lever;
    public int solution(String[] maps) {
        int answer = 0;
        
        //거리 계산 map
        map = new String[maps.length][maps[0].length()];
        
        //방문여부
        visited = new boolean[maps.length][maps[0].length()];
        
        //시작과 레버의 i,j 값
        start = new int[2];
        lever = new int[2];
        
        //maps를 2차원 배열로 만들기
        for(int i=0; i<maps.length; i++) {
            String[] temp = maps[i].split("");
            
            //새로 만든 map에 넣기
            map[i] = temp;
            
            for(int j=0; j<temp.length; j++) {
                //시작
                if(temp[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        //레버까지의 최단 경로 (S에서 L까지)
        int first = bfs(start, "L");
        //레버까지 가는 길이 없다면 -1
        if(first == -1) {
            return -1;
        }
        
        //레버를 거치고 난 후 출구까지 최단 경로 (L에서 E까지)
        //레버까지 가는 길에 들렀던 곳도 다시 가도 되므로 visited 초기화
        visited = new boolean[map.length][map[0].length];
        int second = bfs(lever, "E");
         
        //출구까지 가는 길이 없다면 -1
        if(second == -1) {
            return -1;
        }
        
        answer = first + second;
        
        return answer;
    }
    
    public int bfs(int[] st, String target) {
        Queue<int[]> q = new LinkedList<>();
        
        //시작 넣기
        q.add(new int[]{st[0],st[1],0});
        
        //방문처리
        visited[st[0]][st[1]] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            int cnt = temp[2];
            
            for(int i=0; i<4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                
                //map 범위 안에 있고 아직 방문하지 않았을 때
                if(next_x>=0 && next_x<map.length && next_y>=0 && next_y<map[0].length &&
                  !visited[next_x][next_y]) {
                    //타겟일 때(L,E)
                    if(map[next_x][next_y].equals(target)) {
                        lever[0] = next_x;
                        lever[1] = next_y;
                        return cnt+1;
                    }
                    //벽이 아니고(통로이거나 도착지이거나 레버이거나) 방문하지 않았을 때
                    if(!map[next_x][next_y].equals("X") && !visited[next_x][next_y]) {
                        //방문처리
                        visited[next_x][next_y] = true;
                        q.add(new int[]{next_x,next_y,cnt+1});
                    }
                }
            }
        }
        
        //못찾으면 -1
        return -1;
    }
}

/*
1. S를 먼저 찾은 후, 거기서부터 L까지의 최단경로를 찾는다.
2. 이때는 visited를 활용해서 갔던 곳 방문하지 않게 찾는다. (갔던 곳을 방문하면 최단경로가 아님)
3. L을 찾은 후, L에서부터 E까지의 최단 경로를 구한다.
4. 이때, L까지 갔을 때 들렀던 곳도 갈 수 있으므로 visited를 초기화해준다.
5. 레버까지의 최단경로 + 출구까지의 최단 경로
*/