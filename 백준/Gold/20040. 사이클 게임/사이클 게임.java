import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            answer++;
            st = new StringTokenizer(br.readLine());
            int a = Find(Integer.parseInt(st.nextToken()));
            int b = Find(Integer.parseInt(st.nextToken()));
            if (a != b) {
                Union(a, b);
            } else {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println(answer);
        else System.out.println(0);
    }

    static int Find(int x) {
        if (x == p[x]) return x;
        else return p[x] = Find(p[x]);
    }

    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);
        if (x < y) p[y] = x;
        else p[x] = y;// x > y
    }
}