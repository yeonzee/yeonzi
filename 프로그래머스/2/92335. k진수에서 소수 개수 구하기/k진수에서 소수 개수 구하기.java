import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //n을 k진법으로 변환
        String str = Integer.toString(n,k);
        
        //0을 기준으로 분리하기
        String[] parts = str.split("0");
        
        for (String part : parts) {
            // 빈 문자열 처리
            if (!part.isEmpty()) {
                long a = Long.parseLong(part);
                if (a > 1) {
                    boolean isPrime = true;
                    // 소수 판별
                    for (int j = 2; j <= Math.sqrt(a); j++) {
                        if (a % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}