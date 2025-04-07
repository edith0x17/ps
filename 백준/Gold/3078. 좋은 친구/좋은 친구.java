import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer>[] queues = new ArrayDeque[21];
        for (int i = 0; i < 21; i++) {
            queues[i] = new ArrayDeque<>();
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int len = name.length();
            // 현재 큐에서 등수 차이 K 초과한 애들 제거
            while (!queues[len].isEmpty() && i - queues[len].peek() > k) {
                queues[len].poll();
            }
            answer += queues[len].size();
            
            queues[len].offer(i);
        }
        System.out.println(answer);
    }
}