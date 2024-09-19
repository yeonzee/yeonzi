import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // str1을 쪼갠 리스트
        ArrayList<String> arr1 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2).toLowerCase();
            if (Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                arr1.add(sub);
            }
        }

        // str2을 쪼갠 리스트
        ArrayList<String> arr2 = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2).toLowerCase();
            if (Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                arr2.add(sub);
            }
        }
        
        Collections.sort(arr1);
        Collections.sort(arr2);
        
        //교집합
        ArrayList<String> is = new ArrayList<>();
        //합집합
        ArrayList<String> un = new ArrayList<>();
        
        boolean[] visited = new boolean[arr2.size()];

        for(String s1:arr1) {
            for(int i=0; i<arr2.size(); i++) {
                //같다면 교집합
                if(s1.equals(arr2.get(i)) && !visited[i]) {
                    is.add(s1);
                    visited[i] = true;
                    break;
                }
            }
            un.add(s1);
        }
        
        //arr2에서 남은 문자열 넣기
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                un.add(arr2.get(i));
            }
        }
        
        if(is.size() == 0 && un.size() == 0) {
            return 1*65536;
        }
        
        //실수형으로 계산
        double jakar = 0;
        jakar = (double)is.size() / (double)un.size();
        return (int)(jakar * 65536);
    }
}