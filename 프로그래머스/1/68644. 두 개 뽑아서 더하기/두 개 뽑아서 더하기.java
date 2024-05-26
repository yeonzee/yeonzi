// for문 2개
// 다 더하기
// 중복 제거
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0;i<numbers.length;i++) {
            for (int j=i+1;j<numbers.length;j++) {
                arr.add(numbers[i] + numbers[j]);
            }
        }
        
        Collections.sort(arr);
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int k:arr) {
            if (!list.contains(k)) {
                list.add(k);
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (int k:list) {
            answer[index] = k;
            index++;
        }
        
        return answer;
    }
}