//bfs
import java.util.*;
class Solution {
    static int[] move_x = {-1,1,0,0};
    static int[] move_y = {0,0,-1,1};
    //방문 확인
    static boolean[][] visited;
    static int num;
    
    public int[] solution(String[] maps) {

        //2차원 배열로 만들기
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        //방문 여부 체크
        visited = new boolean[map.length][map[0].length];
        
        //리스트
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                //다른 무인도 가면 숫자 초기화
                num = 0;
                
                //해당 칸이 숫자이고 방문하지 않은 곳이라면 bfs
                if(map[i][j] != 'X' && !visited[i][j]) {
                    bfs(map, i, j);
                }
                
                //주변에 더 이상 갈 곳이 없으면
                if(num != 0) {
                    list.add(num);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        //갈 무인도가 없다면 -1
        if(list.size() == 0) {
            return new int[]{-1};
        }
        
        else {
            //오름차순 정렬
            Collections.sort(list);
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
    
        return answer;
    }
    
    public void bfs(char[][] map,int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        
        //시작 넣기
        q.offer(new int[]{x,y});
        
        //시작 방문 처리
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            //현재
            int[] temp = q.poll();
            int now_x = temp[0];
            int now_y = temp[1];
            
            num += map[now_x][now_y] - '0'; 
            
            for(int i=0; i<4; i++) {
                int next_x = now_x + move_x[i];
                int next_y = now_y + move_y[i];
                
                //범위를 벗어나거나 이미 방문을 했거나 X라면 무시
                if(next_x<0 || next_y<0 || next_x>=map.length || next_y>=map[0].length || visited[next_x][next_y] || map[next_x][next_y] == 'X') {
                    continue;
                }
                else {
                    q.offer(new int[]{next_x, next_y});
                    //방문 처리
                    visited[next_x][next_y] = true;
                }
            }
        }
    }
}