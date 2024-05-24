import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int count = 0;
        for (int i = 0;i<=t.length()-p.length();i++) {
            String a = t.substring(i,i+p.length());
            long b = Long.parseLong(a);
            long c = Long.parseLong(p);
            
            if (b <= c) {
                count++;
            }
        }
        return count;
    }
}