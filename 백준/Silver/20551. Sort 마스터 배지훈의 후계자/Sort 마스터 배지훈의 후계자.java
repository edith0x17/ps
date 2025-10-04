import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
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
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int mx = upperBound(num);
            int mi = lowerBound(num);
            if (mx == mi) System.out.println(-1);
            else System.out.println(mi);
        }
    }

    static int lowerBound(int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    static int upperBound(int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}