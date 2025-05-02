import java.util.*;
class Solution {
    static ArrayList<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        //시작
        move(n,1,2,3);
        
        int[][] answer = new int[arr.size()][2];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
    
    //재귀
    public void move(int n, int start, int mid, int end) {
        //종료조건
        if(n==0) {
            return;
        }
        
        //마지막 원판 빼고 중간으로 몰기
        move(n-1,start,end,mid);
        //list에 담기
        arr.add(new int[]{start, end});
        //중간에서 끝으로 보내기
        move(n-1,mid,start,end);
    }
}