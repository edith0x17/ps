import java.io.*;
import java.util.*;

class Solution {
    static String s = "";
    static int n;
    static int[][] a;
    public int[] solution(int[][] arr) {
        n = arr.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = arr[i][j];
            }
        }
        go(n, 0, 0);
        int cntZero = 0, cntOne = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')cntZero++;
            else cntOne++;
        }
        int[] answer = new int[2];
        answer[0] = cntZero;
        answer[1] = cntOne;
        return answer;
    }
    static boolean check(int size, int x, int y) {
        int prev = a[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (prev != a[i][j]) return false;
            }
        }
        return true;
    }

    static void go(int size, int x, int y) {
        if (check(size, x, y)) {
            if (a[x][y] == 1) s += "1";
            else s += "0";

            return;
        }
        go(size / 2, x, y);
        go(size / 2, x, y + size / 2);
        go(size / 2, x + size / 2, y);
        go(size / 2, x + size / 2, y + size / 2);
    }
}