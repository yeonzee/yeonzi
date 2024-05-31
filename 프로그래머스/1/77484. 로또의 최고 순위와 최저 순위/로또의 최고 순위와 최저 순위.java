import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int[] result = new int[2];
        
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
        
        if (count_good == 6) {
            result[0] = 1;
        }
        else if (count_good == 5) {
            result[0] = 2;
        }
        else if (count_good == 4) {
            result[0] = 3;
        }
        else if (count_good == 3) {
            result[0] = 4;
        }
        else if (count_good == 2) {
            result[0] = 5;
        }
        else {
            result[0] = 6;
        }
        
        if (count_bad == 6) {
            result[1] = 1;
        }
        else if (count_bad == 5) {
            result[1] = 2;
        }
        else if (count_bad == 4) {
            result[1] = 3;
        }
        else if (count_bad == 3) {
            result[1] = 4;
        }
        else if (count_bad == 2) {
            result[1] = 5;
        }
        else {
            result[1] = 6;
        }
        
        
        return result;
    }
}