import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {1, -1, -1, -1};
    static final int[] dy = {1, 1, -1, 1};
    static int w, h, x, y, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        int nx = (x + t) % (2 * w);
        if (nx > w) nx = 2 * w - nx;
        int ny = (y + t) % (2 * h);
        if (ny > h) ny = 2 * h - ny;
        System.out.println(nx + " " + ny);
    }
}