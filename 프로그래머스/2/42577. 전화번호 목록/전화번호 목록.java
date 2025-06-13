import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //앞의 숫자를 기준으로 정렬
        Arrays.sort(phone_book);
        
        //시작하는지 판별 = startsWith
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }
}