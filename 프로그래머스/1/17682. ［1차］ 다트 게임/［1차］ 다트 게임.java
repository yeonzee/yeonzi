import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int index = -1;  // 현재 점수의 인덱스
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                // 숫자가 10일 경우를 처리
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    scores[++index] = 10;
                    i++;  // '0'을 건너뛴다
                } else {
                    scores[++index] = c - '0';
                }
            } else if (c == 'S') {
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (c == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (c == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (c == '*') {
                if (index > 0) { //이전 턴이 존재할 경우
                    scores[index - 1] *= 2; //이전 턴 점수 2배
                }
                scores[index] *= 2; //현재 턴 점수 2배
                
            } else if (c == '#') {
                scores[index] *= -1;
            }
        }
        int answer = 0;
        for (int score : scores) {
            answer += score;
        }
        
        return answer;
    }
}
