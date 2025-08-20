import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Map<String, Integer> mp = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] strings = s.split("\\."); //
            if (mp.containsKey(strings[1])) {
                int cnt = mp.get(strings[1]);
                mp.put(strings[1], cnt + 1);
            } else {
                mp.put(strings[1], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : mp.entrySet()) { //
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}