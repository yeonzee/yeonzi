import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // 모든 요소가 0인 경우 처리
        if (citations[n - 1] == 0) {
            return 0;
        }
        
        for (int i = 0; i < n; i++) {
            int hIndex = n - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
        
        return 0;
    }
}
