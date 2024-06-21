import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        //중복을 없애기 위해 set 사용
        HashSet<String> set = new HashSet<>();
        
        
        //현재 값 초기화 (0,0)
        int nowx = 0;
        int nowy = 0;
        
        for(int i=0;i<dirs.length();i++) {
            int nextx = nowx;
            int nexty = nowy;
            String road = "";
            if(dirs.charAt(i) == 'U') {
                nexty++;
                road += nowx;
                road += nowy;
                road += nextx;
                road += nexty;
            }
            
            //U,D일 경우 road에 반대로 저장하는 이유: 되돌아 가는 경우도 같은 경로로 치기 위해
            else if(dirs.charAt(i) == 'D') {
                nexty--;
                road += nextx;
                road += nexty;
                road += nowx;
                road += nowy;
            }
            
            else if(dirs.charAt(i) == 'R') {
                nextx++;
                road += nowx;
                road += nowy;
                road += nextx;
                road += nexty;
            }
            
            else if(dirs.charAt(i) == 'L') {
                nextx--;
                road += nextx;
                road += nexty;
                road += nowx;
                road += nowy;
            }
            
            //범위를 벗어나면 set에 저장하지 않는다
            if (nextx > 5 || nextx < -5 || nexty > 5 || nexty < -5) {
                continue;
            }
            
            set.add(road);
            
            nowx = nextx;
            nowy = nexty;
        }
        
        return set.size();
    }
}