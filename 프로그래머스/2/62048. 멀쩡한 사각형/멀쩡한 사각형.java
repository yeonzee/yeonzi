//잘린 사각형 갯수 공식: w+h-(w,h의 최대공약수)
import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        long n = (long)w+ (long)h - (long)gcd(w,h);
        
        answer = (long)((long)w * (long)h - n);
        
        return answer;
    }
    
    public long gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}