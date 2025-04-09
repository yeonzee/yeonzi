import java.util.*;
class Solution {
    public int[] solution(int n) {

        int[][] arr = new int[n][n];
        
        int x = -1;
        int y = 0;
        
        int num = 1;
        
        for(int i=0; i<n; i++) {
            //아래
            if(i%3==0) {
                for(int j=i; j<n; j++) {
                    x++;
                    arr[x][y] = num++;
                }
            }
            
            //오른쪽
            else if(i%3==1) {
                for(int j=i; j<n; j++) {
                    y++;
                    arr[x][y] = num++;
                }
            }
            
            //왼쪽 대각선
            else if(i%3==2) {
                for(int j=i; j<n; j++) {
                    x--;
                    y--;
                    arr[x][y] = num++;
                }
            }
        }
            
        //answer에 넣기
        int[] answer = new int[(n*(n+1))/2];
        int idx = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                //0이 아닐경우
                if(arr[i][j] != 0) {
                    answer[idx] = arr[i][j];
                    idx++;
                }
            }
        }
        return answer;
    }
}