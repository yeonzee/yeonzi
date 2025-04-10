//투포인터
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int sum = 0;
        int max_len = sequence.length;
        
        int ans1 = 0;
        int ans2 = 0;
        
        for(int right = 0; right<sequence.length; right++) {
            sum += sequence[right];
            
            //합이 k를 넘어버리면 왼쪽(left)에서 하나씩 빼주기
            if(sum > k) {
                while(sum > k) {
                    sum -= sequence[left];
                    left++;
                }
            }
            //k와 같다면
            if(sum == k) {
                //길이가 짧은 인덱스가 나와야 함
                int len = right-left;
                
                if(len < max_len) {
                    ans1 = left;
                    ans2 = right;
                    max_len = len;
                }
                //길이가 같다면 앞쪽의 인덱스가 나와야 함
                else if(len == max_len) {
                    ans1 = Math.min(ans1, left);
                    ans2 = Math.min(ans2, right);
                }
            }
        }
        
        answer[0] = ans1;
        answer[1] = ans2;
        
        return answer;
    }
}