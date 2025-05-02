import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static ArrayList<Data> adj = new ArrayList<Data>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.add(new Data(num, g, s, b));
        }
        Collections.sort(adj);
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                Data prev = adj.get(i - 1);
                Data curr = adj.get(i);
                if (curr.g != prev.g || curr.s != prev.s || curr.b != prev.b) {
                    rank = i + 1;
                }
            }
            if (adj.get(i).num == k) {
                System.out.println(rank);
                break;
            }
        }
    }

    static class Data implements Comparable<Data> {
        int num;
        int g, s, b;

        public Data(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Data o) {
            if (this.g == o.g) {
                if (this.s == o.s) {
                    return -Integer.compare(this.b, o.b);
                }
                return -Integer.compare(this.s, o.s);
            }
            return -Integer.compare(this.g, o.g);
        }
    }
}