import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        //중복을 방지하기 위해 set 사용
        HashSet<String> set = new HashSet<>();
        
        //0으로 초기화
        int nowx = 0;
        int nowy = 0;
        
        int nextx = 0;
        int nexty = 0;
        
        for(int i=0; i<dirs.length(); i++) {
            
            String road = "";
            
            //U일 경우 y++
            if(dirs.charAt(i) == 'U') {
                nexty++;
                road += nowx;
                road += nowy;
                road += nextx;
                road += nexty;
            }
            
            //D일 경우 U의 역방향
            else if(dirs.charAt(i) == 'D') {
                nexty--;
                road += nextx;
                road += nexty;
                road += nowx;
                road += nowy;
            }
            
            //R일 경우 x++
            else if(dirs.charAt(i) == 'R') {
                nextx++;
                road += nowx;
                road += nowy;
                road += nextx;
                road += nexty;
            }
            
            //L일 경우 R의 역방향
            else {
                nextx--;
                road += nextx;
                road += nexty;
                road += nowx;
                road += nowy;
            }
            
            //범위를 벗어나는 경우는 패스
            if(nextx<-5 || nextx > 5|| nexty<-5 || nexty>5) {
                //범위를 벗어난경우 continue하기 때문에 안 간 것으로 취급해야 함.
                nextx = nowx;
                nexty = nowy;
                continue;
            }
            
            set.add(road);
            
            //갱신
            nowx = nextx;
            nowy = nexty;
            
        }
        
        return set.size();
    }
}

/*
지금 내가 있는 위치: nowx, nowy
내가 움직인 위치: nextx, nexty
U&D로 예를 들어 보자면,
0,0 -> U -> 0,1이 된다
만약 거기서 D가 나온다면
0,1 -> 0,0이 된다.
이 길은 중복이기 때문에 같은 의미를 나타내어야 한다.
그러므오 D는 U의 역행으로 String을 만들었다.
L과 R도 마찬가지!
*/