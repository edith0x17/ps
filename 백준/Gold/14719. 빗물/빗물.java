import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        a = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0, right = 0;
            //왼쪽 제일 큰 블록
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, a[j]);
            }
            //오른쪽 제일 큰 블록
            for (int j = i; j < w; j++) {
                right = Math.max(right, a[j]);
            }
            answer += Math.min(left, right) - a[i];
        }
        System.out.println(answer);
    }
}