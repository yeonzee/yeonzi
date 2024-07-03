//팩토리얼 
import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        long f = 1;
        for(int i=1;i<=n;i++) {
            list.add(i);
            f *= i;
        }
        
        //인덱스가 0부터 시작하기 때문에 k--;
        k--;
        int idx = 0;
        while(idx < n) {
            //순열 조합 몇개인지
            f /= n-idx;
            //몇번째 그룹인지
            answer[idx] = list.remove((int) (k/f));
            //새로운 k 갱신
            k %= f;
            idx++;
        }
        return answer;
    }
}