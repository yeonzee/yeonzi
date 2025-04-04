//1.전체가 다 같은지 판별하는 함수
//2.같지 않다면 크기의 2분의 1하여 다시 판별하는 재귀함수
import java.util.*;
class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        dq(0,0,arr.length,arr);
        
        return answer;
    }
    
    //재귀함수
    public void dq(int startX, int startY, int size, int[][] arr) {
        //다 같은 숫자라면 해당하는 숫자의 answer을 1 증가시킨다
        if(check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            // return;
        }
        //아니라면 재귀함수를 통해 정사각형으로 다시 쪼개기
        else {
            dq(startX, startY, size/2,arr);
            dq(startX+size/2, startY, size/2,arr);
            dq(startX, startY+size/2, size/2,arr);
            dq(startX+size/2, startY+size/2, size/2,arr);
        }
    }
    
    //숫자 판별
    public boolean check(int x, int y, int size, int[][] arr) {
        for(int i=x;i<x+size;i++) {
            for(int j=y;j<y+size;j++) {
                if(arr[i][j] != arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}