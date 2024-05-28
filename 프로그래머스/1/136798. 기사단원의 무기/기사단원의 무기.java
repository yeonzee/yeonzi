// //약수를 저장한 배열 만들기
// //그 배열에서 limit를 넘는 값을 power값 넣기
// //더하기
// import java.util.*;
// class Solution {
//     public int solution(int number, int limit, int power) {
//         int answer = 0;
//         Integer[] a = new Integer[number];
//         int idx=0;
        
//         //약수 저장한 배열
//         for (int i=1;i<=number;i++) {
//             int count = 0;
//             for (int j=1;j<=i;j++) {
//                 if (i % j == 0) {
//                     count++;
//                 }
//             }
//             a[idx] = count;
//             idx++;
//         }
        
//         for (int k=0;k<a.length;k++) {
//             if (a[k] > limit) {
//                 a[k] = power;
//             }
//         }
        
//         for (int num : a) {
//             answer += num;
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisorCounts = new int[number + 1];
        
        // 약수를 효율적으로 구하여 배열에 저장
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCounts[j]++;
            }
        }
        
        // limit을 넘는 값을 power로 대체하고 합산
        for (int i = 1; i <= number; i++) {
            if (divisorCounts[i] > limit) {
                answer += power;
            } else {
                answer += divisorCounts[i];
            }
        }
        
        return answer;
    }
}
