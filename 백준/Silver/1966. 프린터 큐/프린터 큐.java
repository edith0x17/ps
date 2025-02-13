import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Queue<Data> queue = new LinkedList<>(); // 실제 문서 순서 유지
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 중요도가 높은 순 정렬

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Data(priority, i));
                pq.offer(priority);
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                Data data = queue.poll(); // 꺼내기
                if (data.priority == pq.peek()) { // 출력
                    pq.poll();
                    cnt++;

                    if (data.idx == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else { // 다시 넣기
                    queue.offer(data);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Data {
        int priority;
        int idx;

        public Data(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
}