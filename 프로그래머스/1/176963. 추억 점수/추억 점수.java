import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i=0;i<yearning.length;i++) {
            map.put(name[i],yearning[i]);
        }
        
        
        for (int j=0;j<photo.length;j++) {
            int sum = 0;
            for (int k=0;k<photo[j].length;k++) {
                Integer value = map.get(photo[j][k]);
                if (value != null) {
                    sum += map.get(photo[j][k]);
                } 
            }
            answer[j] = sum;
        }
        return answer;
    }
}