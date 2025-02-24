import java.io.*;
import java.util.*;

public class Main {
    static int n, k, answer;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1)root = i; // 루트 노드 저장
            else adj[parent].add(i);
        }
        k = Integer.parseInt(br.readLine());
        if (k == root) {
            System.out.println(0); // 루트를 삭제하면 리프 노드가 없음
            return;
        }
        deleteNode(k);
        go(root);
        System.out.println(answer);
    }
    static void deleteNode(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : adj[cur]) {
                queue.add(child);
            }
            adj[cur].clear(); // ✅ 현재 노드의 모든 자식 삭제
        }

        for (int i = 0; i < n; i++) {
            adj[i].removeIf(child -> child == node); // ✅ 현재 노드의 자기 자신 삭제
        }
    }

    static void go(int node) {
        if (adj[node].isEmpty()) {
            answer++;
            return;
        }

        for (int child : adj[node]) {
            go(child);
        }
    }
}