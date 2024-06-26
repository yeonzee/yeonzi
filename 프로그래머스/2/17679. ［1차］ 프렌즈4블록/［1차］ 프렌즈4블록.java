/*
1.2*2에서 같은 값이 나오면 삭제한다
2.그 갯수를 세어준다
3.내려준다
4.반복해준다
*/

import java.util.*;
class Solution {
    String[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new String[m][n];
        
        for(int i=0;i<board.length;i++) {
            map[i] = board[i].split("");
        }
        
        while(true) {
            int[][] removeMap = checkRemove(m,n);
            
            int removeCnt = remove(m,n,removeMap);
            if(removeCnt == 0) {
                break;
            }
            answer+=removeCnt;
            
            fillDown(m,n);
        }
        return answer;
    }
    
    //삭제한 map
    public int[][] checkRemove(int m, int n) {
        int[][] removeMap = new int[m][n];
        
        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
                String str = map[i][j];
                if(str.equals(" ")){
                    continue;
                }

                if(str.equals(map[i+1][j]) && str.equals(map[i][j+1]) && str.equals(map[i+1][j+1])) {
                    removeMap[i][j] = 1;
                    removeMap[i+1][j] = 1;
                    removeMap[i][j+1] = 1;
                    removeMap[i+1][j+1] = 1;
                    
                }
            }
        }
        return removeMap;
    }
    
    //삭제한 블록 갯수 세기
    public int remove(int m, int n, int[][] removeMap) {
        
        int removeCnt = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(removeMap[i][j] == 1) {
                    map[i][j] = " ";
                    removeCnt++;
                }
            }
        }
        return removeCnt;
    }
    
    //내려보내기
    public void fillDown(int m, int n) {
        for(int i=m-1;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if(map[i][j].equals(" ")){
                    int k=i;

                    //빈공간인 위치에서 가장 가까운 곳을 찾기 = 내려올 원소 찾기
                    while(k>0 && map[k][j].equals(" ")) {
                        k--;
                    }
                    if(!map[k][j].equals(" ")) {
                        map[i][j] = map[k][j];
                        map[k][j] = " ";
                    }
                }
            }
        }
    }
}