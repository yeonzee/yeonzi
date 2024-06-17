/*
2개씩 자른 배열 2개 , 교집합, 합집합 배열 만들기
교집합 갯수와 합집합 갯수를 통해 자카드 유사도 구하기
말처럼 쉽나~~
*/
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        //모두 소문자로 바꿔주기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        //str1 나누기
        for (int i=0; i<str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            //알파벳인지 확인
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                s1.add(first+""+second);
            }
        }
        
        //str2 나누기
        for (int i=0; i<str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            //알파벳인지 확인
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                s2.add(first+""+second);
            }
        }
        
        //교집합과 합집합을 정확하게 만들기 위해서 정렬
        Collections.sort(s1);
        Collections.sort(s2);
        
        for (String s:s1) {
            //s1에 있는 s가 s2에서 삭제가 된다면 공통된 원소가 있다는 뜻이다
            if(s2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        //위 for문에서 s2에 있는 교집합 값을 삭제했기 때문에 합집합에 다 넣음
        for(String s:s2) {
            union.add(s);
        }
        
        double jakar = 0;
        
        //0일 경우
        if(intersection.size() == 0 && union.size() == 0) {
            return 1*65536;
        }
        
        //실수형으로 계산
        jakar = (double)intersection.size() / (double)union.size();
        return (int)(jakar * 65536);
    }
}