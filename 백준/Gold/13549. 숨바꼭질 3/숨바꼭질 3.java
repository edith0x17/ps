import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited = new int[100_001];
    static int answer = Integer.MAX_VALUE;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[n] = 0;
        pq.offer(new Data(n, 0));
        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            int here = cur.pos;
            int time = cur.time;

            if (here == k) {
                answer = Math.min(answer, time);
                continue;
            }

            if (visited[here] < time) continue;

            // 순간이동 (0초)
            int teleport = here * 2;
            if (teleport <= 100_000 && time < visited[teleport]) {
                visited[teleport] = time;
                pq.offer(new Data(teleport, time));
            }

            // 걷기 (1초)
            for (int offset : new int[]{-1, 1}) {
                int there = here + offset;
                if (there >= 0 && there <= 100_000 && time + 1 < visited[there]) {
                    visited[there] = time + 1;
                    pq.offer(new Data(there, time + 1));
                }
            }
        }
        System.out.println(answer);
    }
    static class Data implements Comparable<Data> {
        int pos;
        int time;
        Data(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
        @Override
        public int compareTo(Data o) {
            return this.time - o.time; // 시간 기준 오름차순
        }
    }
}