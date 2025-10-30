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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis();
        System.out.println(adj.size());
    }

    static void lis() {
        adj.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (adj.get(adj.size() - 1) < arr[i]) {
                adj.add(arr[i]);
            } else {
                int pos = Collections.binarySearch(adj, arr[i]);
                if (pos < 0) pos = -(pos + 1);
                adj.set(pos, arr[i]);
            }
        }
    }
}