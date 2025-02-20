import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, mi = Integer.MAX_VALUE;
    static int[] arr, answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l < r) {
            int hap = arr[l] + arr[r];
            if (Math.abs(hap) < mi) {
                mi = Math.abs(hap);
                answer[0] = arr[l];
                answer[1] = arr[r];
                if(Math.abs(hap) == 0)break;
            }
            if (hap >= 0)r--;// 작아져야 함
            else l++;// 커져야 함
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}