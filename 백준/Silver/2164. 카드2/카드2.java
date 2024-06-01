import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            q.offer(i + 1);
        }

        while(q.size() > 1){
            q.poll(); // 제일 위에 있는 카드를 바닥에 버린다

            int temp = q.poll(); // 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다
            q.offer(temp);
        }

        sb.append(q.peek());

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}