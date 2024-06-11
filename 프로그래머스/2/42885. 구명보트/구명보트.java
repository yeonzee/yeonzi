import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 가벼운 사람과 무거운 사람을 함께 태움
                i++;
                j--;
            } else {
                // 무거운 사람만 태움
                j--;
            }
            answer++;
        }
        
        return answer;
    }
}
