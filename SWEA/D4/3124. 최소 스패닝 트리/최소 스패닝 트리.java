import java.awt.dnd.DropTarget;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static long v, e; // int를 long으로 변경
    static long[] p; // int를 long으로 변경
    static Data[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Long.parseLong(st.nextToken()); // int를 long으로 변경
            e = Long.parseLong(st.nextToken()); // int를 long으로 변경

            p = new long[(int)v+ 1]; // int를 long으로 변경
            for (int i = 0; i <= v; i++) p[i] = i;

            d = new Data[(int) (e)]; // int를 long으로 변경

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                long from = Long.parseLong(st.nextToken()); // int를 long으로 변경
                long to = Long.parseLong(st.nextToken()); // int를 long으로 변경
                long c = Long.parseLong(st.nextToken()); // int를 long으로 변경

                d[i] = new Data(from, to, c);
            }

            Arrays.sort(d);

            long ret = 0; // int를 long으로 변경

            for (int i = 0; i < e; i++) {
                long t1 = Find(d[i].from), t2 = Find(d[i].to); // int를 long으로 변경

                if (t1 != t2) { // 다른그룹 이면 -> Union
                    ret += d[i].c;
                    Union(t1, t2);
                }
            }
            System.out.println("#" + tc + ' ' + ret);
        }
    }

    static long Find(long x) { // int를 long으로 변경
        if (x == p[(int)x]) return x;
        else return p[(int)x] = Find(p[(int)x]); // int를 long으로 변경
    }

    static void Union(long x, long y) { // int를 long으로 변경
        x = Find(x); // int를 long으로 변경
        y = Find(y); // int를 long으로 변경
        p[(int)y] = p[(int)x]; // int를 long으로 변경
    }

    static class Data implements Comparable<Data> {
        long from; // int를 long으로 변경
        long to; // int를 long으로 변경
        long c; // int를 long으로 변경

        public Data() {
        }

        public Data(long from, long to, long c) { // int를 long으로 변경
            this.from = from;
            this.to = to;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.c, o.c); // int를 long으로 변경
        }
    }
}
