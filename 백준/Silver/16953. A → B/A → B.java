import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static long A, B;
    static int ret;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Long> q = new ArrayDeque<>();
        q.offer(A);

        while(!q.isEmpty()){
            int S = q.size();

            for(int i = 0; i < S; i++){
                long temp = q.poll();

                if(temp == B)return ret + 1;

                // 1
                if(temp * 2 <= B) q.offer(temp * 2);

                // 2
                if(temp * 10 + 1 <= B)q.offer(temp * 10 + 1);
            }
            ret++;
        }

        return -1;
    }

}