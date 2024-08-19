//dfs
import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> arr;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        arr = new ArrayList<>();
        
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        //정렬
        Collections.sort(arr);
        
        //공백을 기준으로 split
        answer = arr.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String[][] tickets, String start, String str, int depth) {
        //종료조건
        if(depth == tickets.length) {
            arr.add(str);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            //방문하지 않았고
            if(!visited[i]) {
                if(tickets[i][0].equals(start)) {
                    //방문처리
                    visited[i] = true;
                    dfs(tickets, tickets[i][1], str+" "+tickets[i][1], depth+1);
                    visited[i] = false;
                }
            }   
        }
    }
}