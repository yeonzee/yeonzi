import java.util.*;

class Solution {
    int[] X = {1, 0, -1, 0};
    int[] Y = {0, 1, 0, -1};

    public int solution(String[] board) {
        int answer = 0;
        char[][] bd = new char[board.length][board[0].length()];
        int[] start = new int[2];
        
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length(); j++) {
                    bd[i][j] = board[i].charAt(j);
                    if(board[i].charAt(j) == 'R') {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        return bfs(bd, "G", start);
    }

    public int bfs(char[][] bd, String target, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[bd.length][bd[0].length];
        visited[start[0]][start[1]] = 1;        
        queue.add(start);
        int cnt = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            while(size > 0) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];

                for(int i = 0; i < 4; i++) {
                    int idx = 1;
                    while(true) {
                        int x2 = x + X[i] * idx;
                        int y2 = y + Y[i] * idx;

                        if(x2 < 0 || x2 >= bd.length || y2 < 0 || y2 >= bd[0].length || bd[x2][y2]=='D') {
                            int x3 = x2 - X[i];
                            int y3 = y2 - Y[i];

                            if(visited[x3][y3] == 1) {
                                break;
                            }

                            if(bd[x3][y3] == 'G') {
                                return cnt;
                            }

                            queue.add(new int[] {x3, y3});
                            visited[x3][y3] = 1;
                            break;
                        }                      

                        idx++;
                    }
                }                

                size--;
            }
        }        

        return -1;
    }


}
