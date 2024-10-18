import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Data implements Comparable<Data> {
        int f; // 연료량

        Data(int f) {
            this.f = f;
        }

        @Override
        public int compareTo(Data o) {
//            return o.f - this.f; // 연료량 내림차순 (최대 힙)
            return -(this.f - o.f); // 연료량 내림차순 (최대 힙)
        }
    }

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] a = new int[1000001]; // 주유소 정보
        PriorityQueue<Data> pq = new PriorityQueue<>(); // 연료량 기준 우선순위 큐
        boolean flag = false;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int aa = Integer.parseInt(st.nextToken());
            int bb = Integer.parseInt(st.nextToken());
            a[aa] = bb; // 위치 aa에 연료량 bb
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()); // 목적지까지 거리
        int p = Integer.parseInt(st.nextToken()); // 초기 연료

        int answer = 0;

        for (int i = 0; i < l; i++) { // 도착지까지 1km씩 이동
            p--; // 1km 이동할 때마다 연료 1 감소

            // 현재 위치에 주유소가 있으면 우선순위 큐에 넣기
            if (a[i] > 0) {
                pq.offer(new Data(a[i]));
            }

            // 연료가 부족하면
            if (p < 0) {
                // 주유소가 없으면 -1 반환
                if (pq.isEmpty()) {
                    flag = true;
                    sb.append(-1);
                    break;
                } else {
                    // 연료 보충
                    answer++;
                    Data data = pq.poll();
                    p += data.f; // 가장 연료가 많은 주유소 사용
                }
            }
        }

        // 목적지까지 도달했다면 정답 출력
        if (!flag) {
            sb.append(answer);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}