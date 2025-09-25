import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) break;
            for (int j = i + 1; j < n; j++) {
                int sum = a[i] + a[j];
                sum = -1 * sum;
                int mx = upperBound(a, sum, j + 1, n);
                int mi = lowerBound(a, sum, j + 1, n);
                int cnt = mx - mi;
                answer += cnt;
            }
        }
        System.out.println(answer);
    }

    static int lowerBound(int[] arr, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    static int upperBound(int[] arr, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}