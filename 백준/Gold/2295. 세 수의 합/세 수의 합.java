import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // adj <- x + y
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                adj.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(adj);
        for (int i = n - 1; i >= 0; i--) {// d 선택
            for (int j = 0; j <= i; j++) {// z 선택
                int target = arr[i] - arr[j];
                if (Collections.binarySearch(adj, target) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}