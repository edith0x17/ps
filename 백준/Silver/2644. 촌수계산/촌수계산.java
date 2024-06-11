import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int a, b;
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 4];
        for(int i = 0; i < n + 4; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        visited = new int[n + 4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[x].add(y); // 양방향
            adjList[y].add(x); // 양방향
        }

        bfs(a);

        if (visited[b] != 0) sb.append(visited[b] - 1);
        else sb.append(-1);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int here){
        Queue<Integer> q = new ArrayDeque<>();

        visited[here] = 1;
        q.add(here);
        while (!q.isEmpty()) {
            int qSize = q.size();

            while (qSize-- != 0) { // // Flood-fill
                here = q.poll(); // front()& pop()

                for (int there : adjList[here]) {
                    if (visited[there] != 0) continue;

                    q.add(there);
                    visited[there] = visited[here] + 1;
                }
            }
        }
    }
}

