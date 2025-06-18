//장르별 2곡
//장르 내림차순 / 장르 내에서 내림차순 2곡 / 재생 횟수가 같다면 고유 번호가 낮은 순
//이중 해시 맵 사용하는 거 잊지 말기...!!!!
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //장르 맵
        HashMap<String, Integer> genre_map = new HashMap<>();
        //장르 별 재생횟수 인덱스를 담은 맵
        HashMap<String, HashMap<Integer, Integer>> idx_play = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            
            //새로운 장르라면 새로운 맵을 만들어 인덱스 별 저장 횟수 저장
            if(!genre_map.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i,plays[i]);
                idx_play.put(genres[i],map);
            }
            
            //원래 있던 장르라면
            else {
                idx_play.get(genres[i]).put(i,plays[i]);
            }
            
            //밑으로 가는 이유: 맨 위에 있으면 무조건 장르가 있어서 새로운 map을 만들 수 없음
            genre_map.put(genres[i], genre_map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        // System.out.println(genre_map);
        // System.out.println(idx_play);
        
        //genre_map 내림차순 정렬
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
            Collections.sort(arr, (o1,o2) -> map.get(o2) - map.get(o1));
            
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