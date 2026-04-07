import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Data> pq = new PriorityQueue<Data>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(new Data(x));
        }
        int ans = 0;
        while (pq.size() != 1) {
            Data d1 = pq.poll();
            Data d2 = pq.poll();
            int tmp = d1.x + d2.x;
            pq.offer(new Data(tmp));
            ans += tmp;
        }
        System.out.println(ans);
    }

    static class Data implements Comparable<Data> {
        int x;

        public Data(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.x, o.x);
        }
    }
}