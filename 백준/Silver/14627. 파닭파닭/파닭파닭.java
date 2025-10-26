import java.io.*;
import java.util.*;

public class Main {
    static int s, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[s];

        long l = 1, r = 0, best = 0;
        long sum = 0;

        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            r = Math.max(r, arr[i]);
        }

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int i = 0; i < s; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= c) {
                best = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(sum - best * c);
    }
}