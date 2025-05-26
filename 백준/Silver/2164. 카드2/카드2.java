import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            q.offer(i + 1);
        }
        while(q.size() != 1){
            q.poll();
            int temp = q.poll();
            q.offer(temp);
        }
        System.out.println(q.poll());
    }
}