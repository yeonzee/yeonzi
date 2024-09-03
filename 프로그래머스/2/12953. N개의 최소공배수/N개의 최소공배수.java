import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = arr[0]; // 첫 번째 요소로 초기화
        
        for (int i = 1; i < arr.length; i++) {
            int num = gcd(answer, arr[i]); // 현재까지의 최소 공배수와 다음 숫자의 최대 공약수
            answer = (answer * arr[i]) / num; // 최소 공배수 계산
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b); 
        }
    }
}
