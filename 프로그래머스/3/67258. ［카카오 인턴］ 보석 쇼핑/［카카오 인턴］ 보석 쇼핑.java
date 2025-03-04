//답지
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();

        HashMap<String, Integer> gemCount = new HashMap<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;

        while (right < gems.length) {
            // 현재 보석 추가
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;

            // 모든 보석이 포함된 경우 왼쪽 포인터를 줄여서 최소 구간 찾기
            while (gemCount.size() == totalTypes) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                // 왼쪽 보석 제거 후 이동
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                left++;
            }
        }
        return answer;
    }
}