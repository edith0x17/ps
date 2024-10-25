import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 선행 조건 수

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1]; // 각 문제의 진입 차수

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 선행 조건 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to); // from -> to
            inDegree[to]++; // to의 진입 차수를 증가
        }

        // 우선순위 큐 사용하여 위상 정렬 수행
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 문제 번호가 작은 것부터 선택

        // 진입 차수가 0인 문제들 초기화
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 위상 정렬 수행
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            // 현재 문제에 연결된 다음 문제의 진입 차수 줄이기
            for (int next : graph[current]) {
                inDegree[next]--;

                // 진입 차수가 0이 되면 우선순위 큐에 추가
                if (inDegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        // 결과 출력
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}