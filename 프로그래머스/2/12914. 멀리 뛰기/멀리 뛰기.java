//2->2, 3->3, 4->5, 5->8
//피보나치 -> 재귀로 구현하면 시간초과임
import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] fibo = new long[n+1];
        
        fibo[0] = 1;
        fibo[1] = 1;
        
        for(int i=2; i<=n; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        
        return fibo[n];
    }
}