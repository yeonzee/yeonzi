//2차원 배열에 wires값을 1로 넣는다
//간선을 끊는 부분은 0으로 바꾼다
//bfs알고리즘을 통해 간선 갯수의 차이를 구한다
//min을 구한다
import java.util.*;
class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        
        //인접 간선은 1 
        for(int i=0;i<wires.length;i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        //선을 하나씩 끊어보면서 순회
        for(int i=0;i<wires.length;i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            //선을 하나 끊고
            arr[a][b] = 0;
            arr[b][a] = 0;
            
            //bfs
            //a를 기준으로 양 옆 간선 체크 그러므로 bfs에 a 넣음
            answer = Math.min(answer, bfs(n,a));
            
            //다음 순회를 윈해 선 다시 복구
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        return answer;
    }
    
    //bfs
    public int bfs(int n, int start) {
        boolean[] visited = new boolean[n+1];
        int cnt = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        //방문했다.
        visited[start] = true;
        
        //큐가 비었다는 말은 더이상 인접한 노드가 없다는 뜻
        while(!queue.isEmpty()) {
            //현재 노드
            int point = queue.poll();
            
            for(int i=1;i<=n;i++) {
                //방문하지 않았고, 현재 노드에서 간선으로 연결된 노드가 있는 경우
                if(!visited[i] && arr[point][i]==1) {
                    visited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}