//알파벳만 가능 / 대소문자 비교x / 65536을 곱한 후에 소수점 아래 버리기
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> list_1 = new ArrayList<>();
        ArrayList<String> list_2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            String s = str1.substring(i,i+2).toLowerCase();
            //둘 다 알파벳인지 확인
            if(Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(1))) {
                list_1.add(s);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            String s = str2.substring(i,i+2).toLowerCase();
            //둘 다 알파벳인지 확인
            if(Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(1))) {
                list_2.add(s);
            }
        }
  
        //정렬
        Collections.sort(list_1);
        Collections.sort(list_2);
        
        //교집합
        ArrayList<String> is = new ArrayList<>();
        
        //합집합
        ArrayList<String> un = new ArrayList<>();
        
        //중복 제거를 위해 이미 비교했는지 확인
        boolean[] check = new boolean[list_2.size()];
        
        for(String s1:list_1) {
            for(int i=0; i<list_2.size(); i++) {
                String s2 = list_2.get(i);
                if(s1.equals(s2) && !check[i]) {
                    is.add(s1);
                    //이미 중복이 확인되었음으로 처리
                    check[i] = true;
                    break;
                }
            }
            un.add(s1);
        }
        
        //list_2에서 남은 문자열 넣기
        for(int i=0; i<list_2.size(); i++) {
            if(!check[i]) {
                un.add(list_2.get(i));
            }
        }
        
        //0일 경우
        if(is.size() == 0 && un.size() == 0) {
            return 65536;
        }
        
        //실수형으로 계산
        double jakar = 0;
        jakar = (double)is.size() / (double)un.size();
        return (int)(jakar * 65536);
    }
}