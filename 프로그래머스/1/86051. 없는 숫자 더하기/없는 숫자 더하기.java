// 0에서 9까지 다 더한거에서 numbers의 합을 빼줌

import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = -1;

        int sum1 = 0;
        int sum2 = 0;
        
        for (int j = 0;j<10;j++) {
            sum1 += j;
        }
        
        for (int i : numbers) {
            sum2 += i;
        }
        return sum1 - sum2;
    }
}