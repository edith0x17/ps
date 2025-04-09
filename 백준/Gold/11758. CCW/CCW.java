import java.io.*;
import java.util.*;

public class Main {
    static int x1, x2, x3;
    static int y1, y2, y3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());
        int answer = (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2);
        if (answer == 0) System.out.println(0);
        else if (answer > 0) System.out.println(1);
        else System.out.println(-1);
    }
}