import java.util.*;
class Solution {
    public int[] solution(String s) {
            //s 나누기
        String str = s.substring(2,s.length()-2).replace("},{" , "-");
        String[] a = str.split("-");

        //정렬
        Arrays.sort(a, (String s1, String s2) -> s1.length() - s2.length());

        List<Integer> list = new ArrayList<>();

        for (String el : a) {
            String[] check = el.split(",");

            for (int i = 0; i < check.length; i++) {
                int num = Integer.parseInt(check[i]);

                // 중복된 값이 없을 때만 리스트에 추가
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
    return answer;
    }
}
