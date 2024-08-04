import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0;
        
        //정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //빌려준 경우를 체크하기 위한 boolean
        boolean[] lost_check = new boolean[lost.length];
        boolean[] reserve_check = new boolean[reserve.length];
        
        //여벌이 있는데 도난 당한 경우
        for(int i=0; i< lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(!lost_check[i] && !reserve_check[j] && lost[i]==reserve[j]) {
                    lost_check[i] = true;
                    reserve_check[j] = true;
                    
                }
            }
        }
        
        //나머지 계산
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(!lost_check[i] && !reserve_check[j] && (lost[i]==reserve[j]-1 || lost[i]==reserve[j]+1)) {
                    lost_check[i] = true;
                    reserve_check[j] = true;
                    
                }
            }
        }
        
        //빌려준 갯수
        for(int i=0; i<lost_check.length; i++) {
            if(lost_check[i]) {
                count++;
            }
        }
        
        //전체 학생 수 - 빌려야 하는 학생 수 + 빌린 학생 수
        answer = n-lost_check.length+count;
        return answer;
    }
}