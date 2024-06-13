import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 초기 맵 상태 저장
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        // 10일 단위로 검사
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> currentMap = new HashMap<>(map); // 현재 상태 복사
            for (int j = i; j < i + 10; j++) {
                if (currentMap.containsKey(discount[j])) {
                    currentMap.put(discount[j], currentMap.get(discount[j]) - 1);
                }
            }
            // 현재 상태가 모두 0인지 검사
            boolean allZero = true;
            for (int k = 0; k < want.length; k++) {
                if (currentMap.get(want[k]) > 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                answer++;
            }
        }
        
        return answer;
    }
}
