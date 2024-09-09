//하위 문제들이 반복되어 상위문제를 해결한다
//dp1, dp2가 메모제이션 역할
//dp 풀이
//너무 어렵다 흑흑흑 다시 풀면 절대 못풀듯 사실 완벽하게 이해도 못했음

import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        //sticker의 길이가 1이거나 2인 경우
        if(sticker.length == 1) {
            return sticker[0];
        }
        else if(sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        //첫번째 값을 선택하는 것
        int[] dp1 = new int[sticker.length-1];  //맨마지막 값을 사용하면 안되기 때문에 -1
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];  //첫번째 값을 선택했기 때문에 두번째 값 찢어짐 = 첫번째 값 대입
        
        for(int i=2; i<sticker.length-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
            //i-1값이 더 크면 i-1을 선택하고 i는 찢어버림
            //i-2 + sticker[i]의 값이 더 크면 새롭게 i를 선택함
        }
        
        //첫번째 값을 선택하지 않는 것
        int[] dp2 = new int[sticker.length];  //맨 마지막 값 포함해야 함
        dp2[0] = 0;
        dp2[1] = sticker[1];  //첫번째 값 선택하지 않으므로 두번째 값 선택
        
        for(int i=2; i<sticker.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        //각 배열에서 마지막에 있는 누적값 중 큰 값 리턴
        return Math.max(dp1[sticker.length-2], dp2[sticker.length-1]);
    }
}