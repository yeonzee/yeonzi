import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        //붙이기 위해 str로 변경
        for(int i=0; i<numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        //정렬
        Arrays.sort(str, (o1,o2)-> (o2+o1).compareTo((o1+o2)));
        
        //정렬후엔 가장 큰 값이 앞으로 온다
        //모든 원소가 0이면 0 반환
        if(str[0].equals("0")) {
            return "0";
        }
        
        for(int i=0; i<str.length; i++) {
            sb.append(str[i]);
        }
        
        return sb.toString();
    }
}