import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        //각 단어의 최소값 저장
        for (int i=0;i<keymap.length;i++) {
            for (int j=0;j<keymap[i].length();j++) {
                //더 작은 값이 있을 경우
                if (map.containsKey(keymap[i].charAt(j))) {
                    int current_cnt = map.get(keymap[i].charAt(j));
                    //더 작은 값을 넣어준다
                    if (current_cnt > j+1) {
                        map.put(keymap[i].charAt(j),j+1);
                    }
                }
                else {
                    map.put(keymap[i].charAt(j),j+1);
                }
            }
        }
        
        for (int k=0;k<targets.length;k++) {
            int sum = 0;
            for (int a=0;a<targets[k].length();a++) {
                //targets에 있는 단어와 map에서 있는 단어 일치하는지 확인
                char alpha = targets[k].charAt(a);
                Integer min_click = map.get(alpha);
                
                if (min_click != null) {
                    sum += min_click;
                }
                else {
                    sum = -1;
                    break;
                }
            }
            answer[k] = sum;
        }
        return answer;
    }
}