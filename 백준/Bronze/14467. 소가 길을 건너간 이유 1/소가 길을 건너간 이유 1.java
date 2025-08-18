import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] a;

    public static void main(String[] args) throws IOException {
        a = new int[101];
        Arrays.fill(a, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int flag = Integer.parseInt(st.nextToken());
            if (a[num] == -1) {
                a[num] = flag;
            } else if (a[num] != flag) {
                answer++;
                a[num] = flag;
            }
        }
        System.out.println(answer);
    }
}