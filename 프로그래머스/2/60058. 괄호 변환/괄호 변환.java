import java.util.*;

class Solution {
    public String solution(String p) {
        // 1. 빈 문자열인 경우 그대로 반환
        if (p.isEmpty()) {
            return p;
        }

        // 균형 잡힌 괄호 문자열을 올바른 괄호 문자열로 변환하는 재귀 함수 호출
        return recursive(p);
    }

    public String recursive(String p) {
        // 1. 빈 문자열인 경우 그대로 반환 (재귀 종료 조건)
        if (p.isEmpty()) {
            return p;
        }

        Stack<Character> stack = new Stack<>();
        int cnt_open = 0;
        int cnt_close = 0;
        String u = "";
        String v = "";

        // 2. 균형 잡힌 문자열 u와 v로 분리
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt_open++;
            } else {
                cnt_close++;
            }

            // 균형잡힌 문자열 찾기
            if (cnt_open == cnt_close) {
                u = p.substring(0, i + 1); // u는 처음부터 i까지의 부분 문자열
                v = p.substring(i + 1);     // v는 i+1부터 끝까지의 부분 문자열
                break;
            }
        }

        // 3. 올바른 문자열인지 확인
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(u.charAt(i)); // 여는 괄호는 스택에 push
            } else {
                // 닫는 괄호 처리
                if (stack.isEmpty()) {
                    // 스택이 비어있으면 올바른 괄호 문자열이 아니므로 balanceString 호출
                    return balanceString(u, v);
                }
                stack.pop(); // 스택에서 매칭되는 여는 괄호 pop
            }
        }

        // 4. u가 올바른 괄호 문자열인 경우
        if (stack.isEmpty()) {
            // u 뒤에 재귀적으로 변환한 v를 이어 붙임
            return u + recursive(v);
        } else {
            // u가 올바른 괄호 문자열이 아닌 경우, u를 올바른 괄호 문자열로 변환하여 반환
            return balanceString(u, v);
        }
    }

    // u를 올바른 괄호 문자열로 변환하는 메서드
    private String balanceString(String u, String v) {
        // 1. 첫 번째와 마지막 문자 제거
        StringBuilder sb = new StringBuilder(u);
        sb.deleteCharAt(0); // 첫 번째 문자 제거
        sb.deleteCharAt(sb.length() - 1); // 마지막 문자 제거

        // 2. 나머지 문자열의 괄호 방향 뒤집기
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')'); // '('를 ')'로 변환
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '('); // ')'를 '('로 변환
            }
        }

        // 3. 변환된 u와 재귀적으로 변환한 v를 이어 붙여서 올바른 괄호 문자열 반환
        return "(" + recursive(v) + ")" + sb.toString();
    }
}
