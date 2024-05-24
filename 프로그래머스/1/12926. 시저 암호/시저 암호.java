class Solution {
    public String solution(String s, int n) {
        StringBuilder encrypted = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char encryptedChar = (char) (((c - 'a' + n) % 26) + 'a');
                encrypted.append(encryptedChar);
            } else if (Character.isUpperCase(c)) {
                char encryptedChar = (char) (((c - 'A' + n) % 26) + 'A');
                encrypted.append(encryptedChar);
            } else {
                // 공백 등의 문자는 그대로 유지
                encrypted.append(c);
            }
        }
        
        return encrypted.toString();
    }
}
