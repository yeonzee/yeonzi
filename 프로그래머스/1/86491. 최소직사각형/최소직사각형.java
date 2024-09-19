import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        //가로에는 짧은 길이, 세로에는 큰 길이로 정렬
        
        int max_w = 0;
        int max_h = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int w = Math.min(sizes[i][0], sizes[i][1]);
            int h = Math.max(sizes[i][0], sizes[i][1]);
            
            max_w = Math.max(w,max_w);
            max_h = Math.max(h,max_h);
        }
        return max_w*max_h;
    }
}