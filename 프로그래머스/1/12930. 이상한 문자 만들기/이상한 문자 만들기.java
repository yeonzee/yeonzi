class Solution {
    public String solution(String s) {
        // 공백 기준으로 문자열 자르기
        // -1: 공백으로 끝나면 그것도 포함
        String[] strArr = s.split(" ", -1);

        for(int i=0; i < strArr.length; i++) {
            // 한 글자 씩 자르기
            String[] str = strArr[i].split("");
            for(int j=0; j < str.length; j++) { 
                // 짝수인 경우 대문자로 변경
                if(j%2 ==0) {
                    str[j] = str[j].toUpperCase();
                } 
                // 홀수인 경우 소문자로 변경
                else {
                    str[j] = str[j].toLowerCase();
                }

            }
            // 문자열로 합치기
            strArr[i] = String.join("", str);
        }
        // 공백 포함해서 합치기
        return String.join(" ", strArr);
        
    }
}