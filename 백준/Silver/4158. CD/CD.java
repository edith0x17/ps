import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0)break;

            arr1 = new int[n];
            arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                int left = 0, right = m - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr2[mid] < arr1[i]) {
                        left = mid + 1;
                    } else if (arr2[mid] == arr1[i]) {
                        answer++;
                        break;
                    } else {// arr2[mid] > arr1[i]
                        right = mid - 1;
                    }
                }
            }
            sb.append(answer + "\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}