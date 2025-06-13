import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        //뽑은거
        int choice = nums.length/2;

        //중복 제거
        HashSet<Integer> set = new HashSet<>();
        
        for(int n:nums) {
            set.add(n);
        }
        
        if(set.size() >= choice) {
            answer = choice;
        }
        else {
            answer = set.size();
        }
        return answer;
    }
}