import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1
        new_id = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<new_id.length();i++) {
            sb.append(new_id.charAt(i));
        }
        
        //2
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == '-' || ch == '_' || ch == '.')) {  
                sb.deleteCharAt(i);
                i--; // 현재 문자를 삭제했으므로 인덱스를 감소시켜 다음 문자를 검사할 수 있도록 함
            }
        }
        
        //3
        for (int i=0;i<sb.length()-1;i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i+1) == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        
        //4
        if(sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') {
            sb.deleteCharAt(sb.length()-1);
        }
    
        //5
        if (sb.length() == 0) {
            sb.append("a");
        }
        
        //6
        if (sb.length() >= 16) {
            sb = new StringBuilder(sb.substring(0, 15));
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }
        
        //7
        if (sb.length() <= 2) {
            while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
            }      
        }
        
        return sb.toString();
    }
}