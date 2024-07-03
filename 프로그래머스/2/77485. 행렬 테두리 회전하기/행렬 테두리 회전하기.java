import java.util.*;
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        //2차원 배열 만들기
        map = new int[rows+1][columns+1];
        int num=1;
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                map[i][j] = num;
                num++;
            }
        }
        
        int idx=0;
        for(int[] query:queries) {
            answer[idx] = rotate(query);
            idx++;
        }
        return answer;
    }
    
    public int rotate(int[] query) {
        int sx = query[0];
        int sy = query[1];
        int ex = query[2];
        int ey = query[3];
        
        //블록 합개는 겹치므로 미리 저장해놓기
        int prev = map[sx][sy];
        int min = prev;
        
        //오른쪽
        for(int i=sy+1;i<=ey;i++) {
            int temp = map[sx][i];
            map[sx][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        
        //아래
        for(int i=sx+1;i<=ex;i++) {
            int temp = map[i][ey];
            map[i][ey] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        
        //왼쪽
        for(int i=ey-1;i>=sy;i--) {
            int temp = map[ex][i];
            map[ex][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        
        //위
        for(int i=ex-1;i>=sx;i--) {
            int temp = map[i][sy];
            map[i][sy] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        return min;
    }
}