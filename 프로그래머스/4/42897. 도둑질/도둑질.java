import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        //원형이기 때문에
        //1. 첫번째 집을 털고 마지막 집을 털지 않는 경우의 돈의 누적 최댓값 저장
        int[] dp_o = new int[money.length];
        dp_o[0] = money[0];
        dp_o[1] = money[0];
        
        //2. 첫번째 집을 털지 않는 경우의 돈의 누적 최댓값 저장
        int[] dp_x = new int[money.length];
        dp_x[0] = 0;
        dp_x[1] = money[1];
        
        for(int i=2; i<money.length; i++) {
            //현재 집을 털지 않는 경우 터는 경우 중 최댓값 선택
            dp_o[i] = Math.max(dp_o[i-1], dp_o[i-2]+money[i]);
            dp_x[i] = Math.max(dp_x[i-1], dp_x[i-2]+money[i]);
        }
        
        //dp_o는 마지막 집을 털 수 없기 때문에 -2
        return Math.max(dp_o[dp_o.length-2], dp_x[dp_x.length-1]);
    }
}