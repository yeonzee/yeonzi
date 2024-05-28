import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num:nums) {
            //arr에 num이 포함되어 있지 않다면 arr에 num 추가
            if (!arr.contains(num)) {
                arr.add(num);
            }
            //arr사이즈가 n/2보다 크거나 같다면 break
            if (arr.size() >= (nums.length / 2)) {
                break;
            }
        }
        return arr.size();
    }
}