//재귀로 풀면 시간초과 뜸
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i=2; i<=n; i++) {
            arr[i] = (arr[i-1] % 1234567) + (arr[i-2] % 1234567);
        }
        
        return arr[n] % 1234567;
    }
}