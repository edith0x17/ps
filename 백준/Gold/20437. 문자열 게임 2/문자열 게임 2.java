import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] positions = new ArrayList[26];
            for (int i = 0; i < 26; i++) positions[i] = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                positions[str.charAt(i) - 'a'].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            for (int i = 0; i < 26; i++) {
                if (positions[i].size() < K) continue;

                ArrayList<Integer> list = positions[i];
                for (int j = 0; j <= list.size() - K; j++) {
                    int start = list.get(j);
                    int end = list.get(j + K - 1);
                    int len = end - start + 1;

                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minLen + " " + maxLen);
        }
    }
}