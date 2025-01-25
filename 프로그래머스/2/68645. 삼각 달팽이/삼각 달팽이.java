import java.util.*;
class Solution {
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        int num = 0;
        
        int x = -1;
        int y = 0;
        
        for(int i=0; i<n; i++) {
            
            //아래
            if(i%3==0) {
                for(int j=i; j<n; j++) {
                    x++;
                    num++;
                    arr[x][y] = num;
                }
            }
            
            //오른쪽
            else if(i%3==1) {
                for(int j=i; j<n; j++) {
                    y++;
                    num++;
                    arr[x][y] = num;
                }
            }
            
            //대각선 위
            else if(i%3==2) {
                for(int j=i; j<n; j++) {
                    x--;
                    y--;
                    num++;
                    arr[x][y] = num;
                }
            }
        }
        
        int[] answer = new int[num];
        
        //answer에 넣기
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[idx] = arr[i][j];
                idx++;
            }
        }
        
        return answer;
    }
}