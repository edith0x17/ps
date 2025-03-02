import java.io.*;
import java.util.*;

public class Main {
    static int v, maxDistance = Integer.MIN_VALUE, start = -1;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        adj = new ArrayList[v + 1];
        for(int i = 0; i < v + 1; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[v + 1];
        StringTokenizer st;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()); // 현재 노드 번호

            while (true) {
                int to = Integer.parseInt(st.nextToken()); // 연결된 노드
                if (to == -1) break; // -1이면 종료
                int weight = Integer.parseInt(st.nextToken()); // 가중치
                adj[node].add(new Node(to, weight));
            }
        }

        dfs(1, 0);
        visited = new boolean[v + 1];
        maxDistance = Integer.MIN_VALUE; // 거리 초기화
        dfs(start, 0);
        System.out.println(maxDistance);
    }

    static class Node {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dfs(int here, int distance) {
        visited[here] = true;
        if (maxDistance < distance) {
            maxDistance = distance;
            start = here;
        }
        for (Node there : adj[here]) {
            if (visited[there.to])continue;
            dfs(there.to, distance + there.weight);
        }
    }
}