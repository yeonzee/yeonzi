//2->2, 3->3, 4->5, 5->8
//피보나치
//재귀로 구현하면 시간 초과
import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        
        //n+1했더니 런타임오류가 뜸 -> 메모리 최적화 오류 발생...?
        long[] a = new long[2001];
        
        a[1] = 1;
        a[2] = 2;
        
        for(int i=3; i<=n; i++) {
            a[i] = (a[i-1] + a[i-2])%1234567;
        }
        
        return a[n];
    }
}