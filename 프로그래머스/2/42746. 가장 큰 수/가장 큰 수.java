//문제 이해는 했지만 해결방법이 떠오르지 않음 이런거 대체 어떻게 바로바로 떠오르냐....
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        //string배열로 만들기
        String[] arr = new String[numbers.length];
        
        //arr에 넣기
        for(int i=0; i<arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        //숫자 두개를 붙였을 때 큰 수가 오도록 정렬
        Arrays.sort(arr, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        //모든 수가 0일 경우
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}