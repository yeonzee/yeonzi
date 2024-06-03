//HashMap 사용
import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        HashMap<Character, Integer> x = new HashMap<>();
        HashMap<Character, Integer> y = new HashMap<>();
        
        //HashMap에 빈도수 저장
        for (char c:X.toCharArray()) {
            x.put(c, x.getOrDefault(c,0)+1);
        }
        for (char c:Y.toCharArray()) {
            y.put(c, y.getOrDefault(c,0)+1);
        }
        
        //공통 문자를 저장할 리스트
        ArrayList<Character> arr = new ArrayList<>();
        
        for (char c:x.keySet()) {
            if (y.containsKey(c)) {
                int cnt = Math.min(x.get(c),y.get(c));
                for (int i=0;i<cnt;i++) {
                    arr.add(c);
                }
            }
        }
        //정렬
        arr.sort(Collections.reverseOrder());
        
        if (arr.size()==0) {
            return "-1";
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c:arr) {
            sb.append(c);
        }
        
        String result = sb.toString();
        if (result.replaceAll("0","").isEmpty()) {
            return "0";
        }
        
        return result;
    }
}