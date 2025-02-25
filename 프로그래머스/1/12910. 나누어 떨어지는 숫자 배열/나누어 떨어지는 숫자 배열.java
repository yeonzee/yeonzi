import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {

        //리스트
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        //정렬
        Collections.sort(list);
        
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++) {
            answer[j] = list.get(j);

        }
        
        return answer;
    }
}