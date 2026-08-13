import java.util.*;

class Solution {
    static List<Integer> nums = new ArrayList<>();
    static ArrayList<int[]>[] card;

    static boolean[] visited;
    static int[] order;

    static int[][] board;

    static int n;
    static int answer;
    static int startX, startY;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board, int r, int c) {
        Solution.board = board;

        nums.clear();
        answer = Integer.MAX_VALUE;

        startX = r;
        startY = c;

        card = new ArrayList[7];

        for (int i = 0; i < 7; i++) {
            card[i] = new ArrayList<>();
        }

        // 카드 좌표 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    card[board[i][j]].add(new int[]{i, j});
                }
            }
        }

        // 존재하는 카드 번호 저장
        for (int i = 1; i <= 6; i++) {
            if (card[i].size() == 2) {
                nums.add(i);
            }
        }

        n = nums.size();

        visited = new boolean[n];
        order = new int[n];

        dfs(0);

        return answer;
    }

    // 카드 제거 순서 순열
    static void dfs(int depth) {
        if (depth == n) {

            // order 순서가 하나 완성됨
            calc(0, startX, startY, 0);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            order[depth] = nums.get(i);

            dfs(depth + 1);

            visited[i] = false;
        }
    }

    // order 순서는 정해져 있음
    // 각 카드마다 A -> B / B -> A를 모두 확인
    static void calc(int depth, int x, int y, int cost) {
        if (depth == n) {
            answer = Math.min(answer, cost);
            return;
        }

        int num = order[depth];

        int[] a = card[num].get(0);
        int[] b = card[num].get(1);


        // 1. 현재 -> A -> B
        int cnt1 = bfs(x, y, a[0], a[1]);
        int cnt2 = bfs(a[0], a[1], b[0], b[1]);

        // 카드 제거
        board[a[0]][a[1]] = 0;
        board[b[0]][b[1]] = 0;

        // B가 현재 위치가 됨
        calc(
                depth + 1,
                b[0],
                b[1],
                cost + cnt1 + cnt2 + 2
        );

        // 복구
        board[a[0]][a[1]] = num;
        board[b[0]][b[1]] = num;


        // 2. 현재 -> B -> A
        cnt1 = bfs(x, y, b[0], b[1]);
        cnt2 = bfs(b[0], b[1], a[0], a[1]);

        // 카드 제거
        board[a[0]][a[1]] = 0;
        board[b[0]][b[1]] = 0;

        // A가 현재 위치가 됨
        calc(
                depth + 1,
                a[0],
                a[1],
                cost + cnt1 + cnt2 + 2
        );

        // 복구
        board[a[0]][a[1]] = num;
        board[b[0]][b[1]] = num;
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];

        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (x == ex && y == ey) {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {

                /*
                 * 일반 방향키 이동
                 * 한 칸
                 */
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, cnt + 1});
                    }
                }


                /*
                 * Ctrl + 방향키 이동
                 */
                nx = x;
                ny = y;

                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    // 다음 칸이 범위를 벗어나면
                    // 현재 nx, ny가 해당 방향의 끝
                    if (tx < 0 || tx >= 4 || ty < 0 || ty >= 4) {
                        break;
                    }

                    nx = tx;
                    ny = ty;

                    // 카드 만나면 바로 멈춤
                    if (board[nx][ny] != 0) {
                        break;
                    }
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return 0;
    }
}