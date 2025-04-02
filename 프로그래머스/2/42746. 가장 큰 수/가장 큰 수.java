//두 수를 붙인 후 비교 -> 정렬
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        
        //numbers를 string으로 변환
        for(int i=0; i<numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        
        //두 수를 붙이고 비교하였을 때, 큰 수를 앞으로 오도록 배치
        Arrays.sort(arr, (o1,o2) -> ((o2+o1).compareTo(o1+o2)));
        
        //효율성을 높이기 위해 0일때 처리
        //정렬 후 첫번째 수가 0일 때 (= 모든 수가 0일 때) 0으로 처리
        if(arr[0].equals("0")) {
            return "0";
        }
        
        for(String s:arr) {
            answer += s;
        }
        
        return answer;
    }
}