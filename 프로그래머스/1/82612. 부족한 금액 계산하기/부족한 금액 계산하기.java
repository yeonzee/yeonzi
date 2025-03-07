import java.util.*;
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1; i<=count; i++) {
            answer += (long)(price*i);
        }
        
        //금액이 부족하지 않다면
        if(answer <= money) {
            return 0;
        }
        
        return answer - money;
    }
}