import java.io.*;
import java.util.*;

public class Main {
    static class Data implements Comparable<Data> {
        int to, from, price;

        public Data(int to, int from, int price) {
            this.to = to;
            this.from = from;
            this.price = price;
        }

        @Override
        public int compareTo(Data o) {
            return this.price - o.price;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static ArrayList<Data> adj = new ArrayList<>();
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;  // Union-Find 배열 초기화

        for (int i = 0; i < m; i++) {  // m개의 간선 입력
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            adj.add(new Data(from, to, price));
        }

        Collections.sort(adj);  // 간선을 비용 순으로 정렬 (크루스칼 알고리즘)

        int answer = 0;
        for (Data edge : adj) {
            int t1 = edge.from;
            int t2 = edge.to;
            if (Find(t1) != Find(t2)) {  // 사이클이 생기지 않으면
                answer += edge.price;  // 최소 비용 추가
                Union(t1, t2);  // 합치기
            }
        }

        sb.append(answer).append("\n");
        System.out.print(sb);
    }

    static int Find(int x) {
        if (x == p[x]) return x;
        return p[x] = Find(p[x]);
    }

    static void Union(int x, int y) {
        x = Find(x);
        y = Find(y);
        if (x < y) p[y] = x;
        else p[x] = y;
    }
}