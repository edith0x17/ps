import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static ArrayList<ArrayList<Integer>> parties;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        parties = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int person = Integer.parseInt(st.nextToken());
            visited[person] = true;
            queue.offer(person);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();
            int prev = Integer.parseInt(st.nextToken());
            party.add(prev);
            for (int j = 1; j < num; j++) {
                int temp = Integer.parseInt(st.nextToken());
                party.add(temp);
                adj[prev].add(temp);
                adj[temp].add(prev);
                prev = temp;
            }
            parties.add(party); // 현재 파티 정보를 리스트에 저장
        }

        bfs();

        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (visited[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }
        System.out.println(answer);
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int here = queue.poll();
            for (int there : adj[here]) {
                if (visited[there])continue;
                visited[there] = true;
                queue.offer(there);
            }
        }
    }
}