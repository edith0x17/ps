import java.io.*;
import java.util.*;

public class Main {
    static int n, num = 1;
    static String[] names;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            names = new String[n + 1];
            counts = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                names[i] = br.readLine();
            }
            for (int i = 1; i <= 2 * n - 1; i++) {
                String[] parts = br.readLine().split(" ");
                int idx = Integer.parseInt(parts[0]);
                counts[idx]++;
            }
            for (int i = 1; i <= n; i++) {
                if (counts[i] == 1) {
                    System.out.println(num + " " + names[i]);
                }
            }
            num++;
        }
    }
}