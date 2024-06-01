import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가진 학생을 ArrayList에 저장
        ArrayList<Integer> r = new ArrayList<>();
        for (int i : reserve) {
            r.add(i);
        }

        // 여벌 체육복을 가진 학생이 도난당한 경우 먼저 처리
        int cnt = 0;
        ArrayList<Integer> newLost = new ArrayList<>();
        for (int j : lost) {
            if (r.contains(j)) {
                r.remove(Integer.valueOf(j));
                cnt++;
            } else {
                newLost.add(j);
            }
        }

        // 도난당한 학생에게 체육복 빌려주기
        for (int j : newLost) {
            if (r.contains(j - 1)) {
                r.remove(Integer.valueOf(j - 1));
                cnt++;
            } else if (r.contains(j + 1)) {
                r.remove(Integer.valueOf(j + 1));
                cnt++;
            }
        }

        return n - lost.length + cnt;
    }
}
