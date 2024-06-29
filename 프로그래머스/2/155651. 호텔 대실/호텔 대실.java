import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] arr = new int[book_time.length][2];
        
        for(int i=0;i<book_time.length;i++) {
            String[] start_time = book_time[i][0].split(":");
            String[] end_time = book_time[i][1].split(":");
            
            int start = Integer.parseInt(start_time[0])*60 + Integer.parseInt(start_time[1]);
            int end = Integer.parseInt(end_time[0])*60 + Integer.parseInt(end_time[1]) + 10;
            arr[i][0] = start;
            arr[i][1] = end;
            
        }
        
        //시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // 첫 번째 열을 기준으로 오름차순 정렬
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        ArrayList<Integer> endTimes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean allocated = false;
            for (int j = 0; j < endTimes.size(); j++) {
                if (endTimes.get(j) <= arr[i][0]) {
                    endTimes.set(j, arr[i][1]);
                    allocated = true;
                    break;
                }
            }
            if (!allocated) {
                endTimes.add(arr[i][1]);
                answer++;
            }
        }
        return answer;
    }
}