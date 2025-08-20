import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 사전순 출력이 필요하면 TreeMap, 아니면 HashMap + 나중에 정렬
        Map<String, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            int dot = s.lastIndexOf('.');
            String ext = s.substring(dot + 1);        // 마지막 점 뒤가 확장자
            mp.merge(ext, 1, Integer::sum);           // 없으면 1, 있으면 +1
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : mp.entrySet()) {
            sb.append(e.getKey()).append(' ').append(e.getValue()).append('\n');
        }
        System.out.print(sb.toString());
    }
}