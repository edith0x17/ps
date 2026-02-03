import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Data> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//내림차순
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new Data(i, priority));
                pq.offer(priority);
            }
            int rank = 0;
            while (!q.isEmpty()) {
                Data data = q.poll();
                if (data.priority == pq.peek()) {
                    pq.poll();
                    rank++;
                    if (data.num == m) {
                        System.out.println(rank);
                        break;
                    }
                } else {
                    q.offer(data);
                }
            }
        }
    }

    static class Data {
        int num, priority;

        public Data(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
}