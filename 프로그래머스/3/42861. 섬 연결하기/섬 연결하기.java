//크루스칼 알고리즘 -> union_find 자료구조 사용
import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        //부모 리스트
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;  //초기에는 본인 값 저장
        }
        
        //비용 오름차순
        Arrays.sort(costs, (o1,o2) -> o1[2]-o2[2]);
        
        for(int i=0; i<costs.length; i++) {
            int is1 = costs[i][0];
            int is2 = costs[i][1];
            
            //부모 탐색
            int is1_p = find(is1);
            int is2_p = find(is2);
            
            //부모가 같다면 사이클을 형성하므로 간선 생성x
            if(is1_p == is2_p) {
                continue;
            }
            //그렇지 않다면 간선 생성
            //부모 업데이트
            parent[is2_p] = is1_p;
            answer += costs[i][2];
        }
        
        
        return answer;
    }
    //부모 찾기
    public int find(int node) {
        //부모를 찾았다면 반환
        if(parent[node] == node) {
            return node;
        }
        //부모를 찾지 못했다면 재귀하여 다시 탐색
        else {
            return parent[node] = find(parent[node]);
        }
    }
}