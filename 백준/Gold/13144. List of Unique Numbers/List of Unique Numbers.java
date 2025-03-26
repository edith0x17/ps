import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // left는 고정되어 있고 right가 확장되면서 가능한 구간을 센다
        int left = 0;
        long answer = 0;
        for(int right = 0; right < N; right++){
            while(visited[arr[right]]) {
                visited[arr[left]] = false;
                left++;
            }

            visited[arr[right]] = true;
            answer += (right - left + 1);
        }
        System.out.println(answer);
    }
}