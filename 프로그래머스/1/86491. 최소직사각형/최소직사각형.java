import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        Integer[] max = new Integer[sizes.length];
        Integer[] min = new Integer[sizes.length];
        
        
        for (int i=0;i<sizes.length;i++) {
            int w = Math.max(sizes[i][0],sizes[i][1]);
            max[i] = w;
            
            int h = Math.min(sizes[i][0],sizes[i][1]);
            min[i] = h;
        }
        
        int num1 = max[0];
        int num2 = min[0];
        for (int j=1;j<sizes.length;j++) {
            if (num1 < max[j]) {
                num1 = max[j];
            }
            if (num2 < min[j]) {
                num2 = min[j];
            }
        }
        return num1 * num2;
    }
}