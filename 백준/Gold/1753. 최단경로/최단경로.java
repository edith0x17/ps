import java.io.*;
import java.util.*;

public class Main {
    static int v, e, s;
    static ArrayList<Data>[] adj;
    static int[] d;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        d = new int[v + 1];
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
        }
        //초기화
        for (int i = 0; i < v + 1; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;
        pq.add(new Data(s, 0));
        while (!pq.isEmpty()) {
            Data current = pq.poll();//현재 가장 거리 짧은 후보 꺼냄
            int currentNode = current.t;//현재 위치
            int currentDist = current.w;//현재까지 거리

            if (d[currentNode] < currentDist) continue;//이미 더 짧은 거리로 방문한 적 있으면 무시

            for (Data next : adj[currentNode]) {//현재 노드에서 갈 수 있는 모든 노드 확인
                int nextNode = next.t;//다음 노드
                int weight = next.w;//간선 비용
                if (d[nextNode] > d[currentNode] + weight) {// 기존 거리보다 더 짧으면 갱신
                    d[nextNode] = d[currentNode] + weight;
                    pq.add(new Data(nextNode, d[currentNode] + weight));//갱신된 거리로 다시 PQ에 넣기
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (d[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }

    static class Data implements Comparable<Data> {
        int t, w;

        public Data(int t, int w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.w, o.w);
        }
    }
}