import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        a = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < w; i++) {
            //l
            int l = 0;
            for (int j = i - 1; j >= 0; j--) {
                l = Math.max(l, a[j]);
            }
            //r
            int r = 0;
            for (int j = i + 1; j < w; j++) {
                r = Math.max(r, a[j]);
            }

            int water = Math.min(l, r) - a[i];//l, r - 현재
            if (water > 0) ans += water;
        }
        System.out.println(ans);
    }
}