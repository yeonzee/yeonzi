
import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        ArrayList<String> c1 = new ArrayList<>(Arrays.asList(cards1));
        ArrayList<String> c2 = new ArrayList<>(Arrays.asList(cards2)); 
        
        for (int i = 0; i < goal.length; i++) {
            if (!c1.isEmpty() && c1.get(0).equals(goal[i])) {
                c1.remove(0);
            } else if (!c2.isEmpty() && c2.get(0).equals(goal[i])) {
                c2.remove(0);
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}