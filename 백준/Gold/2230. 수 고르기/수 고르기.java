import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, answer = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0, right = 0;
        while (right < n) { // ✅ right가 범위를 벗어나지 않도록 조절
            int temp = arr[right] - arr[left];

            if (temp < m) { // 차이가 부족하면 right 증가
                right++;
            } else { // temp >= m
                // update
                answer = Math.min(answer, temp);
                // check
                if (temp == m) break; // 가장 작은 차이가 m인 경우 바로 종료
                left++; // 차이가 충분하면 left 증가
            }
        }
        System.out.println(answer);
    }
}