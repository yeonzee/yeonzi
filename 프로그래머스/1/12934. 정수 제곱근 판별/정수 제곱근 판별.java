import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double a = Math.sqrt(n);
        
        while(a>=1) {
            a--;
        }
        
        if (a == 0) {
            return (long)Math.pow(Math.sqrt(n)+1,2);
        }
        return -1;
    }
}