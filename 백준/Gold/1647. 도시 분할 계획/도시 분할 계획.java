import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer, bigCost;
    static ArrayList<Data> adj = new ArrayList<>();
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            p[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.add(new Data(f, t, c));
        }
        Collections.sort(adj);
        for (Data data : adj) {
            int t1 = data.from;
            int t2 = data.to;
            if (Find(t1) != Find(t2)) {  // 사이클이 생기지 않으면
                answer += data.cost;  // 최소 비용 추가
                Union(t1, t2);  // 합치기
                bigCost = data.cost;
            }
        }
        System.out.println(answer - bigCost);
    }
    static int Find(int x){
        if(x == p[x])return x;
        else return p[x] = Find(p[x]);
    }
    static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        if(x < y)p[y] = x;
        else p[x] = y;
    }
    static class Data implements Comparable<Data>{
        int from, to, cost;
        public Data(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Data o){
            return this.cost - o.cost;
        }
    }
}