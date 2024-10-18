import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int n, m, islandCnt;
    static int[][] map;
    static int[] parents;
    static Queue<int[]> q;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[][] check;
    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        islandCnt = 2;
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    islandIndexing(i, j, islandCnt); // x, y 바꿈
                    islandCnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    makeBridge(i, j, map[i][j]); // x, y 바꿈
                }
            }
        }
        islandCnt--;
        parents = new int[islandCnt];
        for (int i = 1; i < islandCnt; i++) {
            parents[i] = i;
        }
        int answer = shortestPath();
        System.out.println(answer == 0 ? -1 : answer);

    }

    // 1번 로직 (그래프 색칠)
    static void islandIndexing(int x, int y, int idx) { // x, y 순서 유지
        q = new LinkedList<>();
        // push visited, logic
        q.add(new int[] { x, y });
        check[x][y] = true;
        map[x][y] = idx;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1 || check[nx][ny])
                    continue;

                if (map[nx][ny] == 1) {
                    q.add(new int[] { nx, ny });
                    check[nx][ny] = true;
                    map[nx][ny] = idx;
                }
            }
        }
    }

    // 2번 로직 (그래프 연결)
    static void makeBridge(int x, int y, int idx) { // x, y 순서 유지
        q = new LinkedList<>();
        check = new boolean[n][m];
        for (int d = 0; d < 4; d++) {
            q.add(new int[] { x, y, 0 });
            check[x][y] = true;

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int move = p[2];

                int nx = px + dx[d];
                int ny = py + dy[d];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1 || check[nx][ny])
                    continue;

                if (map[nx][ny] != idx) {
                    if (map[nx][ny] != 0) {
                        int from = idx - 1;
                        int to = map[nx][ny] - 1;
                        int bridgeLen = move;
                        if (bridgeLen > 1) {
                            pq.add(new Node(from, to, bridgeLen));
                            break;
                        }
                    } else {
                        q.add(new int[] { nx, ny, move + 1 });
                        check[nx][ny] = true;
                    }
                }
            }

            q.clear();
        }
    }

    // 3번 로직 (최소 신장트리 - 크루스칼)
    static int shortestPath() {
        int sum = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node node = pq.poll();
            int x = node.from;
            int y = node.to;

            if (find(x) != find(y)) {
                sum += node.value;
                union(x, y);
            }
        }

        int rx = parents[1];
        for (int i = 2; i < islandCnt; i++) {
            if (rx != find(parents[i])) {
                return 0;
            }
        }

        return sum;
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        int rx = find(parents[x]);
        return rx;

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x<y) {
            parents[y]=x;
        }
        else {
            parents[x] =y;
        }
    }
}