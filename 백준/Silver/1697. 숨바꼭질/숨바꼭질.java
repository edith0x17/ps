import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] vistied = new int[100_004];
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        vistied[n] = 1;
        q.offer(n);
        while(!q.isEmpty()){
            int here = q.poll();
            for(int there: new int[]{here - 1, here + 1, here * 2}){
                if(there < 0 || there > 100_000)continue; // 범위
                if(vistied[there] != 0)continue; // 방문
                // 장애물
                vistied[there] = vistied[here] + 1;
                q.offer(there);
            }
        }
        System.out.println(vistied[k] - 1);
    }
}