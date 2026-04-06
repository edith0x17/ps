import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Data(s, e));
        }
        int end = 0, ans = 0;
        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            if (end <= cur.s) {//현재끝 <= 다음시작
                end = cur.e;//다음끝
                ans++;
            }
        }
        System.out.println(ans);
    }

    static class Data implements Comparable<Data> {
        int s, e;

        public Data(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Data o) {
            if (this.e == o.e) return Integer.compare(this.s, o.s);
            return Integer.compare(this.e, o.e);//e
        }
    }
}