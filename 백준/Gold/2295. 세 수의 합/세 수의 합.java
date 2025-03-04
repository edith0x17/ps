import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // x + y + z = d
        // x + y = d - z
        for (int i = n - 1; i >= 0; i--) { // d를 선택
            for (int j = 0; j < i; j++) {  // x를 선택
                for (int k = j; k < i; k++) {  // y를 선택
                    int target = arr[i] - arr[j] - arr[k];  // 🔹 z를 찾기 위한 값

                    if (Arrays.binarySearch(arr, 0, n, target) >= 0) {
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
    }
}