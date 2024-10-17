//장르별 2곡
//많이 재생된 장르/장르 내에서 많이 재생된 노래/ 재생 횟수가 같다면 고유 번호가 낮은 순
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //장르별 총 횟수를 담을 map
        HashMap<String, Integer> genre_map = new HashMap<>();
        //장르별 인덱스별 횟수를 담을 map
        HashMap<String, HashMap<Integer, Integer>> idx_play = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            
            //새로운 장르라면 새로운 맵을 만들어 인덱스 별 재생 횟수 저장
            if(!genre_map.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                idx_play.put(genres[i], map);
            }
            
            //원래 있던 장르라면
            else {
                idx_play.get(genres[i]).put(i, plays[i]);  //idx_play.get(genres[i]) = map
            }
            
            //이 문장이 밑에 있는 이유: 맨 윗줄에 있으면 genre_map에 모든 장르가 다 들어가서 else문이 실행이 안됨
            genre_map.put(genres[i], genre_map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        // System.out.println(genre_map);
        // System.out.println(idx_play);
        
        //총 재생 횟수가 많은 장르 순으로 정렬 (내림차순)
        //key값을 정렬할 리스트
        ArrayList<String> list = new ArrayList<>(genre_map.keySet());
        Collections.sort(list, (o1,o2) -> genre_map.get(o2)-genre_map.get(o1));
        
        //결과값을 담을 리스트
        ArrayList<Integer> result = new ArrayList<>();
        
        for(String str:list) {
            //인덱스, 재생횟수 map
            HashMap<Integer, Integer> map = idx_play.get(str);
            //인덱스를 담을 리스트
            ArrayList<Integer> arr = new ArrayList<>(map.keySet());
            
            //재생횟수 내림차순 정렬
            Collections.sort(arr, (o1,o2) -> map.get(o2)-map.get(o1));
            
            //가장 큰 값 담기
            result.add(arr.get(0));
            //2개 이상이라면 그 다음 값 담기
            if(arr.size()>1) {
                result.add(arr.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}