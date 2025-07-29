import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Map<String, Integer> mp = new HashMap<>();
    static int n;
    static int kingX, kingY, stoneX, stoneY;

    public static void main(String[] args) throws IOException {
        mp.put("T", 0);
        mp.put("RT", 1);
        mp.put("R", 2);
        mp.put("RB", 3);
        mp.put("B", 4);
        mp.put("LB", 5);
        mp.put("L", 6);
        mp.put("LT", 7);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        n = Integer.parseInt(st.nextToken());
        kingX = 8 - (king.charAt(1) - '0'); //숫자 부분: 1~8 → 7~0
        kingY = king.charAt(0) - 'A'; //문자 부분: A~H → 0~7
        stoneX = 8 - (stone.charAt(1) - '0');
        stoneY = stone.charAt(0) - 'A';
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int dir = mp.get(s);
            int nx = kingX + dx[dir];
            int ny = kingY + dy[dir];
            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue; //범위

            if (nx == stoneX && ny == stoneY) {
                int tx = stoneX + dx[dir];
                int ty = stoneY + dy[dir];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8) continue; //범위

                stoneX = tx;
                stoneY = ty;
            }
            kingX = nx;
            kingY = ny;
        }
        System.out.printf("%c%d\n", kingY + 'A', 8 - kingX);
        System.out.printf("%c%d\n", stoneY + 'A', 8 - stoneX);
    }
}