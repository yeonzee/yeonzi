import java.util.*;
class Solution {
    static int num = 0;
    static boolean[][] visited;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};
    static char[][] ch;
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public int[] solution(String[] maps) {

        //2차원 배열
        ch = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < ch.length; i++) {
            ch[i] = maps[i].toCharArray();
        }


        for(int i = 0; i < ch.length; i++) {
            for(int j = 0; j < ch[i].length; j++) {          
                if(ch[i][j] != 'X') {
                    num = 0;
                    if(!visited[i][j]) {
                        num = Character.getNumericValue(ch[i][j]);
                        bfs(i, j, num);    
                    }
                    if(num != 0) {
                        list.add(num);

                    }
                }
            }
        }

        int[] answer = new int[list.size()];

        if(list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }else {
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    public static void bfs(int x, int y, int cnt) {

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {

            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++) {

                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];

                if(nextX < 0 || nextY < 0 || nextX >= ch.length || nextY >= ch[0].length || visited[nextX][nextY]) continue;

                if(ch[nextX][nextY] != 'X') {
                    q.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    cnt += Character.getNumericValue(ch[nextX][nextY]);
                }
            }
            num = cnt;
        }
    }
}