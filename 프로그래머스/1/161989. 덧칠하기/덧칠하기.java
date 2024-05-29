//빈곳을 false
//false인 부분들을 m개씩 채워주기
import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] a = new boolean[n+1];
        Arrays.fill(a,true);
    
        for (int num:section) {
            a[num] = false;
        }
        
        int count = 0;
        for (int i=1;i<=n;i++) {
            if(!a[i]) {
                count++;
                i += m-1;
            }
        }
        return count;
    }
}