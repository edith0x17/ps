import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, answer;
    static ArrayList<Integer> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            adj.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 0; i < n; i++){
            int cnt = 0;
            if(adj.contains(adj.get(i)))cnt++;
            if(adj.contains(adj.get(i) + 1))cnt++;
            if(adj.contains(adj.get(i) + 2))cnt++;
            if(adj.contains(adj.get(i) + 3))cnt++;
            if(adj.contains(adj.get(i) + 4))cnt++;
            answer = Math.max(answer, cnt);
        }
        sb.append(5 - answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}