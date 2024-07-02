import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        int[] answer = new int[n];
        k--;  // 0-based 인덱싱을 위해 k를 감소
        
        long factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        
        int index = 0;
        while (n > 0) {
            int selected = (int) (k / factorial);
            answer[index++] = numbers.get(selected);
            numbers.remove(selected);
            
            k %= factorial;
            if (n > 1) {
                factorial /= (n - 1);
            }
            n--;
        }
        
        return answer;
    }
}
