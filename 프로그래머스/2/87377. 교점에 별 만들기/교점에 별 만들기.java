//답지
import java.util.*;
class Solution {
    static long minx = Long.MAX_VALUE, miny = Long.MAX_VALUE;
    static long maxx = Long.MIN_VALUE, maxy = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> points = new ArrayList<>();

        // x = (bf - ed) / (ad - bc)
        // y = (ec - af) / (ad - bc)
        long x, y;
        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a * d - b * c;
                if (adbc == 0) continue; // 직선이 평행할 경우

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) continue; // x가 정수가 아닐 경우

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) continue; // y가 정수가 아닐 경우

                x = bfed / adbc;
                y = ecaf / adbc;
                points.add(new long[] { x, y }); // 좌표를 배열로 저장

                minx = Math.min(minx, x);
                miny = Math.min(miny, y);
                maxx = Math.max(maxx, x);
                maxy = Math.max(maxy, y);
            }
        }

        // 좌표계 크기 계산
        long height = maxy - miny + 1;
        long width = maxx - minx + 1;
        answer = new String[(int) height];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }
        Arrays.fill(answer, sb.toString());

        // 별표를 바로 배열에 찍기
        for (long[] p : points) {
            answer[(int) (maxy - p[1])] = answer[(int) (maxy - p[1])].substring(0, (int) (p[0] - minx)) + "*"
                    + answer[(int) (maxy - p[1])].substring((int) (p[0] - minx) + 1);
        }

        return answer;
    }
}
