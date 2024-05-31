import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int count_good = 0;
        int count_bad = 0;
        
        for (int a:lottos) {
            if (a==0) {
                count_good++;
            }
            for (int b:win_nums) {
                if (a==b) {
                    count_good++;
                    count_bad++;
                }
                
            }
        }
        int[] answer = {Math.min(7 - count_good, 6), Math.min(7 - count_bad, 6)};
        return answer;

    }
}