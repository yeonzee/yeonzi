//n이 2만 있다고 생각해서 틀림
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s<n) {  //n이 s보다 크면 n개가 모두 1이여도 s를 만들 수 없다는 뜻
            return new int[]{-1};
        }
        
        int a = s/n;
        int b = s%n;
        
        for(int i=0; i<n; i++) {
            answer[i] = a;
        }
        
        for(int j=0; j<b; j++) {
            answer[j]++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}