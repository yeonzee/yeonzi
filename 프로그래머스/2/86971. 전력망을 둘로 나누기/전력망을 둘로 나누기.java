//bfs
import java.util.*;
class Solution {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        
        //연결되어 있는 부분 1로 초기화
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        //하나씩 끊어보기
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            
            answer = Math.min(answer,bfs(n, wires[i][0]));  //wires[i][0] 만 넣는 이유: 자른 구간을 기준으로 한 구역만 계산
            
            //백트래킹
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        return answer;
    }
    
    //bfs에서 각 전력망들의 갯수 차이 구하기
    public int bfs(int n, int start) {
        //방문처리
        boolean[] visited = new boolean[n+1];
        
        //시작하면서 나를 방문하기 때문에 1로 초기화
        int cnt = 1;
        
        //나 자신 방문처리
        visited[start] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            for(int i=1; i<n+1; i++) {
                if(!visited[i] && map[temp][i] == 1) {  //갈 수 있음
                    visited[i] = true;
                    cnt++;
                    q.offer(i);
                }
            }
        }
        
        return Math.abs(n-2*cnt);
    }
}