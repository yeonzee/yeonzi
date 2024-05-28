//

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num:nums) {
            if (!arr.contains(num)) {
                arr.add(num);
            }
            if (arr.size() >= (nums.length / 2)) {
                break;
            }
        }
        return arr.size();
    }
}