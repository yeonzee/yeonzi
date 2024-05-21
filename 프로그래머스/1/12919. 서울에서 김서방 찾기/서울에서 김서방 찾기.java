class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i<seoul.length;i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}

// 문자열 비교할 때는 .equals 사용!!!