import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                go(i, j);
            }
        }
        System.out.println(answer);
    }

    static void go(int i, int j) {
        int first = arr[i] + arr[j];
        int l = 0, r = n - 1;
        while (l < r) {
            if (l == i || l == j) {
                l++;
                continue;
            }
            if (r == i || r == j) {
                r--;
                continue;
            }

            int second = arr[l] + arr[r];
            int diff = Math.abs(first - second);
            answer = Math.min(answer, diff);
            
            if (first <= second) r--;
            else l++;//first > second
//            if (second < first) {
//                l++;
//            } else {//second >= first
//                r--;
//            }
        }
    }
}