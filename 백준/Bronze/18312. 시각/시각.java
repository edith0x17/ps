import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int h = 0; h <= n; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    String time = String.format("%02d%02d%02d", h, m, s);
                    if (time.contains(String.valueOf(k))) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}