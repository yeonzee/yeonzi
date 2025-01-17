//dfs
import java.util.*;
class Solution {
    static boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            //방문하지 않았을 경우
            if(!check[i]) {
                dfs(computers, i);
                
                //dfs 순회하고 온 만큼 네트워크 형성
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int i) {
        
        //방문처리
        check[i] = true;
        
        for(int j=0; j<computers.length; j++) {
            //나 자신이 아니고 && 연결되어있고 && 방문하지 않았을 때
            if(i!=j && computers[i][j] == 1 && !check[j]) {
                dfs(computers, j);
            }
        }
    }
}