//피보나치 수열 문제
//dp이용
import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] a = new long[2001];
        
        a[1] = 1;
        a[2] = 2;
        
        for (int i=3;i<=n;i++) {
            a[i] = (a[i-1] + a[i-2]) % 1234567;
        }
        
        return a[n];
    }
}