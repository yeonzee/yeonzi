import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //약수를 배수를 통해서 구하기
        //number+1 -> 인덱스와 숫자를 일치시키기 위해
        int[] a = new int[number + 1];    
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                a[i * j]++;
            }
        }
        
        // limit을 넘는 값을 power로 대체하고 합산
        for (int k=0;k<a.length;k++) {
            if (a[k] > limit) {
                a[k] = power;
            }
        }
        
        for (int num : a) {
            answer += num;
        }
        return answer;
    }
}