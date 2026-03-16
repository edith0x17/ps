import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] priCnt;
    static Queue<Data> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        priCnt = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            answer += w;
            priCnt[p]++;
            q.offer(new Data(p, w));
        }
        ArrayList<Integer> adj = new ArrayList<>();
        while (m > 0) {
            Data cur = q.poll();

            if (cur.p != m) {
                answer += cur.w;
                q.offer(cur);
            } else {
                priCnt[cur.p]--;
                int tmp = 0;
                for (int i : adj) {
                    if (i < cur.w) tmp += i;
                }
                answer += tmp * 2;
                adj.add(cur.w);
                if (priCnt[m] == 0) {
                    m--;
                    adj = new ArrayList<>();
                }
            }
        }
        System.out.println(answer);
    }

    static class Data {
        int p, w;

        public Data(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
}