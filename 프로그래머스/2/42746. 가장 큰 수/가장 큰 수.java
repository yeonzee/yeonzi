import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
          //내림차순
        Arrays.sort(arr,(o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        //모든 원소가 0일 경우
        if(arr[0].equals("0")){
            return "0";
        }        
      
        
        StringBuilder sb = new StringBuilder();
        
        for(int j=0;j<arr.length;j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}