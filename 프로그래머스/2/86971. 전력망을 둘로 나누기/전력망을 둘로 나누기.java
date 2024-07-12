/* 다시 풀어보려 했지만 도저히 아이디어가 생각이 안남
어떻게 이런 생각이 드나 신기할 따름...
2차원 배열 만들어서 해당 노드가 있다면 1
하나씩 끊어가면서(0으로 변경) 검사
내 노드 양쪽을 검사하는 것이므로 bfs
개수의 차이는 n-2*cnt 하면 나옴 (이건 어케 아노)
*/
import java.util.*;
class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        
        //해당 노드가 있다면 1로 변경
        for(int i=0; i<wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        //하나씩 끊으면서 bfs
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            //끊기
            arr[a][b] = 0;
            arr[b][a] = 0;
            
            //더 작은 값이 answer
            //a 주변 노드 중심으로 bfs
            answer = Math.min(answer, bfs(n,a));
            
            //다시 확인하기 위해 연결
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        return answer;
    }
    
    public int bfs(int n, int start) {
        //방문확인 노드 하나만 가면 방문한 것이기 때문에 []
        boolean[] visited = new boolean[n+1];
        //내 노드에서 출발(포함)하기 때문에 1로 시작
        int cnt = 1;
        
        //시작으로 방문함
        visited[start] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            //현재 노드
            int point = queue.poll();
            
            //인덱스 값으로 구하기 위해 i=1
            for(int i=1; i<=n; i++) {
                //방문 안했고 노드끼리 연결되어 있다면
                if(!visited[i] && arr[point][i] == 1) {
                    cnt++;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}