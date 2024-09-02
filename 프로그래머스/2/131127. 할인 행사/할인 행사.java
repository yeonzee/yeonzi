import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;

        // 구매해야 하는 전체 아이템 수 계산
        for(int n : number) {
            total += n;
        }

        // 슬라이딩 윈도우 방식 적용
        for (int i = 0; i <= discount.length - total; i++) {
            // number 배열 복사 (초기화 용도)
            int[] temp = Arrays.copyOf(number, number.length);

            // 현재 윈도우의 아이템 체크
            for (int j = i; j < i + total; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        temp[k]--;  // 해당 품목 수량 감소
                    }
                }
            }

            // 모든 수량이 0이 되었는지 확인
            boolean allZero = true;
            for (int n : temp) {
                if (n != 0) {
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
