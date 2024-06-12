//피보나치 수열
import java.util.*;
class Solution {
    public long solution(int n) {
        long[] memo = new long[2001];
        memo[1] = 1; //한칸을 뛰는 방법 : 1가지
        memo[2] = 2; //두칸을 뛰는 방법 : 2가지

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }

        return memo[n];
    }
}