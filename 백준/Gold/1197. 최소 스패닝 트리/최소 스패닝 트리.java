import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static int[] p = new int[10004]; // UnionFind
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 10004; i++) p[i] = i; // make set
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Data(from, to, cost));
        }

        int ret = 0;
        while(!pq.isEmpty()){
            Data d = pq.poll();

            int t1 = Find(d.f); int t2 = Find(d.t);
            if(t1 != t2){
                Union(t1, t2);
                ret += d.c;
            }
        }

        System.out.println(ret);
    }

    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);
        p[y] = p[x];
    }

    static int Find(int x) {
        if (x == p[x]) return x;
        else return p[x] = Find(p[x]);
    }

    static class Data implements Comparable<Data> {
        int f;
        int t;
        int c;

        public Data(int f, int t, int c) {
            this.f = f;
            this.t = t;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.c, o.c); // 오름차순
        }
    }
}