import java.io.*;
import java.util.*;

public class Main{
    static int n, d, k, c;
    static int[] arr, visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new int[d + 1];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // i %n
        int mx = 0, cnt = 0;
        for(int i = 0; i < k; i++){
            if(visited[arr[i]] == 0)cnt++;
            visited[arr[i]]++;
        }
        if(visited[c] == 0)cnt++;
        visited[c]++;
        mx = cnt;
        for(int i = 1; i < n; i++){
            // LEFT
            visited[arr[i - 1]]--;
            if(visited[arr[i - 1]] == 0)cnt--;

            // RIGHT
            visited[arr[(i + (k - 1)) % n]]++;// i + (k - 1)
            if(visited[arr[(i + (k - 1)) % n]] == 1)cnt++;

            mx = Math.max(mx, cnt);
        }
        System.out.println(mx);
    }
}