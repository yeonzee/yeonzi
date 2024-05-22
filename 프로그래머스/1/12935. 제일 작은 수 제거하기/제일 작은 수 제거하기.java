import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        // 배열 길이가 1이면 -1 리턴
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        // 제일 작은 수 찾기(버블정렬?)
        int num = arr[0];
        for (int i = 0;i<arr.length;i++) {
            if (num > arr[i]) {
                num = arr[i];
            }
        }
        
        // 제일 작은 수 num과 같지 않은 수를 배열에 넣기
        int index = 0;
        for (int a:arr) {
            if (a != num) {
                answer[index] = a;
                index++;
            }
        }
        return answer;
    }
}