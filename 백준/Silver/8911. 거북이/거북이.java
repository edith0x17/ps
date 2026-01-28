import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int x = 0, y = 0, dir = 0, minX = 0, maxX = 0, minY = 0, maxY = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                } else if (s.charAt(i) == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                } else if (s.charAt(i) == 'L') {
                    dir = (dir + 3) % 4;//-1 == 4 - 1 == 3
                } else {//R
                    dir = (dir + 1) % 4;
                }
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}