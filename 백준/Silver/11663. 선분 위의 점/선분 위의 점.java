import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int left = lowerBound(a, l);
            int right = upperBound(a, r);
            System.out.println(right - left);
        }
    }

    static int lowerBound(int[] arr, int target) { //target 이상
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int upperBound(int[] arr, int target) { //target 초과
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}