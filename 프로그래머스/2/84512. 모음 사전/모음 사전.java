import java.util.*;

class Solution {
    static String[] alpha;
    static int answer;
    static boolean fin = false;

    public int solution(String word) {
        answer = 0;
        fin = false;
        alpha = new String[]{"A","E","I","O","U"};
        dfs(0, word, "");
        return answer;
    }

    public void dfs(int depth, String word, String w) {
        if (fin) return;                 // 이미 찾았으면 더 진행 X
        if (w.equals(word)) {            // 정답 발견
            fin = true;
            return;
        }
        if (depth == 5) return;          // 길이 5 제한

        for (int i = 0; i < alpha.length; i++) {
            if (fin) return;             // ★ 루프 도중에도 즉시 중단
            answer++;                    // 방문(생성)하는 단어 개수 카운트
            dfs(depth + 1, word, w + alpha[i]);
        }
    }
}
