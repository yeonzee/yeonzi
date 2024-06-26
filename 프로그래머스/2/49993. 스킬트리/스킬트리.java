import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree:skill_trees) {
            int idx_1 = 0;
            boolean isValid = true;
            
            for(char c:skill_tree.toCharArray()) {
                int idx_2 = skill.indexOf(c);
                
                if(idx_2 == -1) {
                    continue;
                }
                
                if(idx_1 == idx_2) {
                    idx_1++;
                }
                else {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                answer++;
            }
        }
        return answer;
    }
}