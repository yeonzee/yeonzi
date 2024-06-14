/* 
우선 최소공배수는 (n*m / 최대공약수)로 구할 수 있음
최대공약수는 gcd
*/
import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        //arr에 원소가 1개인 경우
        if (arr.length == 1) {
            answer = arr[0];
        }
        
        int g = gcd(arr[0],arr[1]); // 처음 두 원소의 최대공약수
        answer = (arr[0] * arr[1]) / g; // 처음 두 원소의 최소공배수
        
        //arr의 길이가 3이상인 경우 앞 두 원소의 최소공배수와 그 다음에 오는 원소의 최소공배수 
        
        if (arr.length > 2) {
            for (int i=2; i<arr.length;i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }
        return answer;
    }
    //최대공약수
    public static int gcd(int a, int b) {
        int r = a%b;
        if (r==0) {
            return b;
        }
        else {
            return gcd(b,r);
        }
    }
}