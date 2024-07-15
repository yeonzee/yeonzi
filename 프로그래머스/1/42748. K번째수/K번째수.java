import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            //부분배열 만들기
            int[] sub = Arrays.copyOfRange(array,i-1,j);
            
            //서브쿼리 정렬
            Arrays.sort(sub);
            
            //k값 찾기
            answer[a] = sub[k-1];
        }
        return answer;
    }
}