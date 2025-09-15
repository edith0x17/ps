import java.io.*;
import java.util.*;

public class Main {
    static long s, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        long l = 1, r = s;
        while (l <= r) {
            long mid = (l + r) / 2;

            long sum = (mid * (mid + 1)) / 2;
            if (sum > s) {
                r = mid - 1;
            } else { //sum <= s
                answer = mid;
                l = mid + 1;
            }
        }
        System.out.println(answer);
    }
}