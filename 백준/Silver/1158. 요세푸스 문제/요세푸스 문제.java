import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            q.offer(i + 1);
        }

        sb.append("<");
        int cnt = 0;
        while(!q.isEmpty()){
            int ret = q.poll();
            cnt++;

            if(cnt == k){
                if(q.size() == 0){
                    sb.append(ret);
                }else sb.append(ret + ", ");
                cnt = 0;
            }else q.offer(ret);
        }
        sb.append(">");

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}