import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = check(board);
        return answer;
    }

    static int check(String[] board) {
        int cntO = 0, cntX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') cntO++;
                else if (board[i].charAt(j) == 'X') cntX++;
            }
        }

        if (!(cntO == cntX || cntO == cntX + 1)) return 0;

        boolean flagO = checkWin(board, 'O');
        boolean flagX = checkWin(board, 'X');
        if (flagO && flagX) return 0;
        if (flagO && cntO != cntX + 1) return 0;
        if (flagX && cntO != cntX) return 0;

        return 1;
    }

    static boolean checkWin(String[] board, char target) {
        //가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target &&
                    board[i].charAt(1) == target &&
                    board[i].charAt(2) == target)
                return true;
        }
        //세로
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == target &&
                    board[1].charAt(i) == target &&
                    board[2].charAt(i) == target)
                return true;
        }
        ///대각선
        if (board[0].charAt(0) == target &&
                board[1].charAt(1) == target &&
                board[2].charAt(2) == target) return true;
        if (board[0].charAt(2) == target &&
                board[1].charAt(1) == target &&
                board[2].charAt(0) == target) return true;
        return false;
    }
}
// 1. O == X or O == X+1
// 2. O win → O == X+1
// 3. X win → O == X
// 4. 둘 다 win → invalid