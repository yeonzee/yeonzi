//0~9까지의 합에서 numbers의 합 빼기
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        //0~9까지의 합
        int sum1 = 0;
        for(int i=0; i<10; i++) {
            sum1 += i;
        }
        
        //numbers의 합
        int sum2 = 0;
        for(int num:numbers) {
            sum2 += num;
        }
        
        return sum1-sum2;
    }
}