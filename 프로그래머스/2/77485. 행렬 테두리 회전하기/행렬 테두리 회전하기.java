import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int num = 1;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
        
        int idx = 0;
        for(int[] q:queries) {
            int start_x = q[0]-1;
            int start_y = q[1]-1;
            int last_x = q[2]-1;
            int last_y = q[3]-1;
            
            //이전 값
            int temp1 = 0;
            //현재 값
            int temp2 = 0;
            
            //제일 작은 값
            int min = rows*columns;
            
            //오른쪽
            temp1 = map[start_x][start_y];
            for(int i=start_y; i<last_y; i++) {
                temp2 = map[start_x][i+1];
                map[start_x][i+1] = temp1;
                temp1 = temp2;
                min = Math.min(min,temp2);
            }
    
            //아래
            for(int i=start_x; i<last_x; i++) {
                temp2 = map[i+1][last_y];
                map[i+1][last_y] = temp1;
                temp1 = temp2;
                min = Math.min(min,temp2);
            }
            
            //왼쪽
            for(int i=last_y; i>start_y; i--) {
                temp2 = map[last_x][i-1];
                map[last_x][i-1] = temp1;
                temp1 = temp2;
                min = Math.min(min,temp2);
            }
            
            //위
            for(int i=last_x; i>start_x; i--) {
                temp2 = map[i-1][start_y];
                map[i-1][start_y] = temp1;
                temp1 = temp2;
                min = Math.min(min,temp2);
            }
            
            answer[idx] = min;
            idx++;
            
            // for(int k=0; k<map.length; k++) {
            //     for(int h=0; h<map[0].length; h++) {
            //         System.out.print(map[k][h]);
            //     }
            //     System.out.println();
            // }
        }
        return answer;
    }
}