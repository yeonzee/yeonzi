import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int count = 0;
        int row = board.length;
        int column = board[0].length;
        
        if (h>0 && board[h-1][w].equals(board[h][w])) {
        count++;
        }
        
        if (w>0 && board[h][w-1].equals(board[h][w])) {
        count++;
        }
        
        if (h<row-1 && board[h+1][w].equals(board[h][w])) {
            count++;
        }
        if (w<column-1 && board[h][w+1].equals(board[h][w])) {
            count++;
        }
        
        return count;
    }
}