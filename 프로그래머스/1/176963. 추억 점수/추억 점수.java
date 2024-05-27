//HashMap을 사용해야 한다고 생각
import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        //name과 yearning의 각각의 값 할당
        for (int i=0;i<yearning.length;i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int j=0;j<photo.length;j++) {
            int sum = 0;
            for (int k=0;k<photo[j].length;k++) {
                //map에 photo[j][k]에 해당하는 값의 value 값
                Integer num = map.get(photo[j][k]);
                
                if (num != null) {
                    sum += num;
                }
            }
            answer[j] = sum;
        }
        return answer;
    }
}