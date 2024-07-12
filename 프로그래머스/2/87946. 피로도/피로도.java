class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            //k보다 작고 방문하지 않았다면 탐험 가능
            if(dungeons[i][0]<=k && !visited[i]) {
                visited[i] = true;
                dfs(depth+1,k-dungeons[i][1],dungeons);
                //백트래킹 돼서 돌아오면 방문을 못한 것이므로 false
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}