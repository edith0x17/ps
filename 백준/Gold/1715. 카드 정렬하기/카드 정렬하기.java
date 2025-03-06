import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        if (n == 1) System.out.println(0);
        else {
            int answer = 0;
            while (!pq.isEmpty()) {
                int a = pq.poll();
                int b = pq.poll();
                answer += (a + b);

                if (pq.isEmpty()) break;
                else pq.offer(a + b);
            }
            System.out.println(answer);
        }
    }
}