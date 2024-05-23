class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        //s의 길이가 4 혹은 6이 아니면 false
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        //try_catch
        try {
            int a = Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;      
        }
    }
}