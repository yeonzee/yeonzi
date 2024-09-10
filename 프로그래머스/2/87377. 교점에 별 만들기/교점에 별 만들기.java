//너무 어렵다
//참고 사항의 식을 이용하여 존재하는 교점을 넣을 리스트 생성
//최대x, 최소x, 최대y, 최소y를 구하여 범위 설정
//.으로 채운 배열 생성
//for문을 통해 리스트에 있는 교점들을 *로 변환
//long으로 변경해야 완전 통과됨
import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        
        ArrayList<long[]> arr = new ArrayList<>();
        
        //최대값들 구하기
        long minx = Long.MAX_VALUE;
        long miny = Long.MAX_VALUE;
        long maxx = Long.MIN_VALUE;
        long maxy = Long.MIN_VALUE;
        
        for(int i=0; i<line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j=i; j<line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                if((a*d)-(b*c) == 0) {  //평행하거나 같은 직선이므로 무시
                    continue;
                } 
                if(((b*f)-(e*d)) % ((a*d)-(b*c)) != 0) {  //x가 정수가 아님
                    continue;
                }
                if(((e*c)-(a*f)) % ((a*d)-(b*c)) != 0) {  //y가 정수가 아님
                     continue;
                }
                
                long x = ((b*f)-(e*d)) / ((a*d)-(b*c));
                long y = ((e*c)-(a*f)) / ((a*d)-(b*c));
                
                arr.add(new long[]{x,y});
                
                minx = Math.min(minx, x);
                miny = Math.min(miny, y);
                maxx = Math.max(maxx, x);
                maxy = Math.max(maxy, y);
                
            }
        }
        
        //높이 넓이 구하기 (ex)2,5일때 2,3,4,5가 포함되어야 하므로 +1을 해줌
        long height = maxy - miny+1;
        long width = maxx - minx+1;
        
        String[] answer = new String[(int)height];
        
        //가로 .으로 채우기
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<width; i++) {
            sb.append(".");
        }
        
        //answer값에 sb 채우기
        Arrays.fill(answer, sb.toString());
        
        //교점 별표로 변경하기
        //이해실패
        for(long[] p:arr) {
            answer[(int) (maxy - p[1])] = answer[(int) (maxy - p[1])].substring(0, (int) (p[0] - minx)) + "*"
                    + answer[(int) (maxy - p[1])].substring((int) (p[0] - minx) + 1);
        }
        
        return answer;
    }
}