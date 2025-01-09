import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //행렬 그리기(인덱스 1부터 시작)
        int[][] map = new int[rows+1][columns+1];
        int num=1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
        
        int idx = 0;
        
        for(int[] a:queries) {
            //최솟값(가장 큰 값 넣어놓기)
            int min = rows*columns;
            
            //임시저장
            int temp = map[a[0]][a[1]];
            
            int start_r = a[0];
            int start_c = a[1];
            int last_r = a[2];
            int last_c = a[3];
            
            //왼쪽줄 회전
            while(true) {
                //마지막에 도달했으면 끝
                if(start_r == last_r) {
                    break;
                }
                map[start_r][start_c] = map[start_r+1][start_c];
                start_r++;
                
                min = Math.min(min, map[start_r][start_c]);
            }
            
            //아래줄 회전
            while(true) {
                //마지막에 도달했으면 끝
                if(start_c == last_c) {
                    break;
                }
                map[start_r][start_c] = map[start_r][start_c+1];
                start_c++;
                
                min = Math.min(min, map[start_r][start_c]);
            }
            
            //오른쪽줄 회전
            while(true) {
                //마지막에 도달했으면 끝
                if(start_r == a[0]) {
                    break;
                }
                map[start_r][start_c] = map[start_r-1][start_c];
                start_r--;
                
                min = Math.min(min, map[start_r][start_c]);
            }
            
            //윗줄 회전
            while(true) {
                //마지막에 도달했으면 끝
                if(start_c == a[1]) {
                    break;
                }
                map[start_r][start_c] = map[start_r][start_c-1];
                start_c--;
                
                min = Math.min(min, map[start_r][start_c]);
            }
            
            //임시값 넣어주기
            map[a[0]][a[1]+1] = temp;
            min = Math.min(min, map[a[0]][a[1]+1]);
            
            answer[idx] = min;
            idx++;
        }
        return answer;
    }
}