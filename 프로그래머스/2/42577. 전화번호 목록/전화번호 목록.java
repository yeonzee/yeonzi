import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //앞의 숫자를 기준으로 정렬하기
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }
}