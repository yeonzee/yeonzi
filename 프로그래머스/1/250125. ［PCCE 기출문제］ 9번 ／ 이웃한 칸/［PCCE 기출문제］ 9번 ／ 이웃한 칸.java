import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int row = board.length;
        int column = board[0].length;
        
        //위
        if(h > 0 && board[h-1][w].equals(board[h][w])) {
            answer++;
        }
        
        //아래
        if(h < row-1 && board[h+1][w].equals(board[h][w])) {
            answer++;
        }
        
        //왼쪽
        if(w > 0 && board[h][w-1].equals(board[h][w])) {
            answer++;
        }
        
        //오른쪽
        if(w < column-1 && board[h][w+1].equals(board[h][w])) {
            answer++;
        }
        
        return answer;
    }
}