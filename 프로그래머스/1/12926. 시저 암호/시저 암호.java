class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        //n이 26을 초과하여도 알파벳을 한 바퀴 돌려서 계산
        n = n % 26;
        
        
        for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
            //소문자
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            //대문자
            else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer += ch;
        }
        return answer;
    }
}
