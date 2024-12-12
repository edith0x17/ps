import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited = new int[100_001]; // 시간 저장
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, Integer.MAX_VALUE); // 초기화: 모든 노드에 무한대 시간
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // {위치, 시간} 최소 힙
        pq.offer(new int[]{n, 0}); // 시작점 {위치, 시간}
        visited[n] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int here = current[0];
            int time = current[1];

            if (here == k) {
                answer = Math.min(answer, time);
                continue;
            }

            // 이미 더 짧은 경로로 방문한 경우 무시
            if (visited[here] < time) continue;

            // 순간이동 (0초 소요)
            int teleport = 2 * here;
            if (teleport <= 100_000 && time < visited[teleport]) {
                visited[teleport] = time;
                pq.offer(new int[]{teleport, time});
            }

            // 걷기 (1초 소요)
            for (int offset : new int[]{1, -1}) {
                int there = here + offset;
                if (there >= 0 && there <= 100_000 && time + 1 < visited[there]) {
                    visited[there] = time + 1;
                    pq.offer(new int[]{there, time + 1});
                }
            }
        }
        System.out.println(answer);
    }
}