import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0;i<n;i++) {
            //5글자씩 나와야 하기 때문에 format으로 형식 지정
            //replace를 통해 공백은 0으로 설정
            //2진수 변환 -> Integer.toBinaryString
            String a1 = String.format("%" + n + "s",Integer.toBinaryString(arr1[i])).replace(" ","0");
            String a2 = String.format("%" + n + "s",Integer.toBinaryString(arr2[i])).replace(" ","0");
            
            
            String s = "";
            for (int j=0;j<n;j++) {
                if (a1.charAt(j)=='1' || a2.charAt(j)=='1') {
                    s += "#";
                }
                else {
                    s += " ";
                }
            }
            answer[i] = s;
        }
        return answer;
    }
}