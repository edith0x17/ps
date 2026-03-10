import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Data> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new Data(p, i));
            }
            int rank = 0;
            while (!q.isEmpty()) {
                Data cur = q.poll();
                
                boolean bigger = false;
                for (Data d : q) {
                    if (d.p > cur.p) {
                        bigger = true;
                        break;
                    }
                }
                if (bigger) {
                    q.offer(cur);//다시넣기
                } else {
                    rank++;
                    if (cur.num == m) {
                        System.out.println(rank);
                        break;
                    }
                }
            }
        }
    }

    static class Data {
        int p, num;

        public Data(int p, int num) {
            this.p = p;
            this.num = num;
        }
    }
}