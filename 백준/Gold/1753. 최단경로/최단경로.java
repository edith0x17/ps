import java.io.*;
import java.util.*;

public class Main {
    static class Data implements Comparable<Data>{// from
        int to;// to
        int distance;// distance
        public Data(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
        @Override
        public int compareTo(Data o){
            return this.distance - o.distance;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int v, e, k;
    static ArrayList<Data>[] adj = new ArrayList[20004];
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    static int[] d = new int[20004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 20004; i++){
            adj[i] = new ArrayList<Data>();
            d[i] = 987654321;
        }
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());// start
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, distance));
        }

        d[k] = 0;
        pq.add(new Data(k, 0));
        while(!pq.isEmpty()){
            Data data = pq.poll();
            int here = data.to;
            int distance = data.distance;
            
            if (d[here] < distance) continue;// 최적화

            for(Data there: adj[here]){
                if(d[there.to] > d[here] + there.distance){// 직빵 > 우회
                    d[there.to] = d[here] + there.distance;
                    pq.add(new Data(there.to, d[there.to]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (d[i] == 987654321) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
}