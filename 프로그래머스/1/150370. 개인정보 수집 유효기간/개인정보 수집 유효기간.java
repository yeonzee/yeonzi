import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String item : terms) {
            String[] parts = item.split(" "); 
            String key = parts[0];
            int value = Integer.parseInt(parts[1]); 
            map.put(key, value); 
        }
        
        String[] td = today.split("\\.");
        int y = Integer.parseInt(td[0]);
        int m = Integer.parseInt(td[1]);
        int d = Integer.parseInt(td[2]);
        
        for (int i=0;i<privacies.length;i++) {
            String[] part = privacies[i].split(" ");
            String[] ymd = part[0].split("\\.");
            int yy = Integer.parseInt(ymd[0]);
            int mm = Integer.parseInt(ymd[1]);
            int dd = Integer.parseInt(ymd[2]);
            String kk = part[1];
            
            mm = mm + map.get(kk);
            
            if (mm > 12) {
                if (mm % 12 == 0) {
                    yy = yy + (mm/12) - 1;
                    mm = 12;
                }
                else {
                    yy = yy + (mm / 12);
                    mm = mm % 12;
                }
            }
            
            if (y > yy || (y == yy && m > mm) || (y == yy && m == mm && d >= dd)) {
                arr.add(i + 1);
            }  
        }
        
        Collections.sort(arr);
        
        int[] answer = new int[arr.size()];
        
        for (int i=0;i<arr.size();i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}