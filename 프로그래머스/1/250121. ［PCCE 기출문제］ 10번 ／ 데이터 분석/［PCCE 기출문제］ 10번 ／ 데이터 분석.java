//스트림 사용
import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        int[][] filterdata = Arrays.stream(data).filter(x -> x[map.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(filterdata, (o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]);
        
        return filterdata;
    }
}