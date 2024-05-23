class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        for (int i=0;i<s.length();i++) {
            //아스키코드로 변환해서 숫자가 아닌 것들
            if (s.charAt(i) < '0' || s.charAt(i) > '9') 
                return false;
        }        
        return true;
    }
}