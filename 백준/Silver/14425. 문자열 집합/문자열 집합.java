import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<String> set = new TreeSet<>();
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 선행 조건 수
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            set.add(s);
        }
        int answer = 0;
        for(int i = 0; i < m; i++){
            String s = br.readLine();
            if(set.contains(s))answer++;
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}