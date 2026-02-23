import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<String, Integer> mp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        ArrayList<Word> a = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            a.add(new Word(entry.getKey(), entry.getValue()));
        }
        Collections.sort(a);
        StringBuilder sb = new StringBuilder();
        for (Word word : a) {
            sb.append(word.s).append("\n");
        }
        System.out.print(sb);
    }

    static class Word implements Comparable<Word> {
        String s;
        int cnt;

        public Word(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt == o.cnt) {
                if (this.s.length() == o.s.length()) {
                    return this.s.compareTo(o.s);
                }
                return Integer.compare(o.s.length(), this.s.length());//내림차순
            }
            return Integer.compare(o.cnt, this.cnt);//내림차순
        }
    }
}