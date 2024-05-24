import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        int count = 0;
        
        //오름차순 정렬
        Arrays.sort(d);
        
        for (int i : d) {
            total += i;
            if (total > budget) {
                break;
            }
            count++;
        }
        
        return count;
    }
}