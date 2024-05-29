import java.util.*;
class Solution {
    public int solution(int[] nums) {

        // Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    arr.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        int count_a = 0;
        for (int a:arr) {
            int count_b = 0;
            for (int b=1;b<=a;b++) {
                if(a % b==0) {
                    count_b++;
                }
            }
            if (count_b==2) {
                count_a++;
            }
        }

        return count_a;
    }
}