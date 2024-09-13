import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] l_check = new boolean[lost.length];
        boolean[] r_check = new boolean[reserve.length];
        
        //내가 내것을 잃어버리는 경우 먼저 구하기
        for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                if(!r_check[i] && !l_check[j] && reserve[i] == lost[j]) {  //내가 내것을 잃어버림
                    l_check[j] = true;
                    r_check[i] = true;
                }
            }
        }
        
        //내 체육복을 잃어버린 경우를 제외하고 빌려주는 경우
        for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                
                if(!r_check[i] && !l_check[j] && (reserve[i]-1 == lost[j] || reserve[i]+1 == lost[j])) {  //앞뒤 친구한테 빌려줌
                    l_check[j] = true;
                    r_check[i] = true;
                }
            }
        }
        
        for(int i=0; i<l_check.length; i++) {
            if(!l_check[i]) {
                answer--;
            }
        }
        return answer;
    }
}