import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        
        // 각 노드의 인접 노드를 담을 리스트 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        // 인접한 노드끼리 연결
        for (int j = 0; j < edge.length; j++) {
            int v = edge[j][0];
            int w = edge[j][1];
            
            list.get(v).add(w);
            list.get(w).add(v);
        }
        
        // BFS를 통해 최대 거리 구하기
        return bfs(n);
    }
    
    public int bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); // {현재 노드, 거리}
        visited[1] = true;
        int maxDistance = 0;
        int maxDistanceCount = 0;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int node = temp[0];
            int distance = temp[1];
            
            if (distance > maxDistance) {
                maxDistance = distance;
                maxDistanceCount = 1; // 가장 멀리 떨어진 노드의 거리가 갱신된 경우
            } else if (distance == maxDistance) {
                maxDistanceCount++; // 가장 멀리 떨어진 노드의 거리와 동일한 경우
            }
            
            for (int neighbor : list.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, distance + 1});
                }
            }
        }
        
        return maxDistanceCount; // 가장 먼 노드의 개수 반환
    }
}
