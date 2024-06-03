/*
내가 푸는 방식으로 푸니 시.간.초.과
StringBuilder를 사용해서 시간복잡도를 줄일려 하였으나
StringBuilder에서 삭제를 하면 그것 또한 for문과 비슷하게 흘러가게 되면서 시간복잡도 상승
HashMap을 사용하여 빈도수 저장
*/
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 빈도수를 저장할 HashMap 생성
        Map<Character, Integer> x = new HashMap<>();
        Map<Character, Integer> y = new HashMap<>();

        // X 문자열의 각 문자 빈도수 계산
        for (char c : X.toCharArray()) {
            x.put(c, x.getOrDefault(c, 0) + 1);
        }

        // Y 문자열의 각 문자 빈도수 계산
        for (char c : Y.toCharArray()) {
            y.put(c, y.getOrDefault(c, 0) + 1);
        }

        // 공통된 문자를 저장할 리스트
        List<Character> arr = new ArrayList<>();

        // X의 빈도수를 기준으로 공통된 문자를 찾기
        for (char c : x.keySet()) {
            if (y.containsKey(c)) {
                int commonCount = Math.min(x.get(c), y.get(c));
                for (int i = 0; i < commonCount; i++) {
                    arr.add(c);
                }
            }
        }

        // 공통된 문자가 없다면 -1 반환
        if (arr.isEmpty()) {
            return "-1";
        }

        // 공통된 문자를 내림차순으로 정렬
        arr.sort(Collections.reverseOrder());

        // StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        // 결과 문자열이 모두 '0'으로 구성된 경우 "0" 반환
        String result = sb.toString();
        if (result.replaceAll("0", "").isEmpty()) {
            return "0";
        }

        return result;
    }
}
