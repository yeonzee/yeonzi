import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        return recursive(p);
    }

    public String recursive(String p) {
        if (p.isEmpty()) {
            return p;
        }

        Stack<Character> stack = new Stack<>();
        int cnt_open = 0;
        int cnt_close = 0;
        String u = "";
        String v = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt_open++;
            } else {
                cnt_close++;
            }

            // 균형잡힌 문자열
            if (cnt_open == cnt_close) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        // 올바른 문자열인지 확인
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return balanceString(u, v);
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return u + recursive(v);
        } else {
            return balanceString(u, v);
        }
    }

    private String balanceString(String u, String v) {
        StringBuilder sb = new StringBuilder(u);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);

        // 괄호 방향 뒤집기
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        return "(" + recursive(v) + ")" + sb.toString();
    }
}
