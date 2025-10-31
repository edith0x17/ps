import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Long temp = Long.parseLong(br.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        long num = Long.MAX_VALUE; int cnt = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey(); int freq = entry.getValue();
            if (freq > cnt) {
                cnt = freq;
                num = key;
            } else if (freq == cnt) {
                num = Math.min(num, key);
            }
        }
        System.out.println(num);
    }
}