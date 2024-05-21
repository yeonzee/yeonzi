import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> a = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                a.add(arr[i]);
            }
        }
        
        if (a.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(a);
        
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        
        return answer;
    }
}