import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] flags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        flags = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int flag = Integer.parseInt(st.nextToken());
            if (flag == 1) flags[i] = true;
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) flags[i - 1] = true;
                else flags[i - 1] = false;
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a == 2) {
                    for (int i = b; i <= c; i++) {
                        flags[i - 1] = !flags[i - 1];
                    }
                } else if (a == 3) {
                    for (int i = b; i <= c; i++) {
                        flags[i - 1] = false;
                    }
                } else {//a == 4
                    for (int i = b; i <= c; i++) {
                        flags[i - 1] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (flags[i]) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }
}