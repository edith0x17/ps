import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] a = new char[12][6];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        int chainCount = 0;
        while (true) {
            visited = new boolean[12][6];
            boolean isPopped = false;
            // 1
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && a[i][j] != '.') {
                        if (bfs(i, j)) isPopped = true;
                    }
                }
            }
            // 2
            if (!isPopped) break; // 터질 뿌요 없으면 종료
            // 3
            drop(); // 뿌요 내리기
            // 4
            chainCount++; // 연쇄 증가
        }
        System.out.println(chainCount);
    }

    static boolean bfs(int x, int y) {
        ArrayList<Data> puyoGroup = new ArrayList<>();

        Queue<Data> q = new ArrayDeque<>();
        q.offer(new Data(x, y, a[x][y]));
        visited[x][y] = true;
        puyoGroup.add(new Data(x, y, a[x][y]));
        while (!q.isEmpty()) {
            Data here = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = here.x + dx[i];
                int ny = here.y + dy[i];
                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue; // 범위
                if (visited[nx][ny] || a[nx][ny] != here.c) continue; // 방문 || 장애물
                visited[nx][ny] = true;
                q.offer(new Data(nx, ny, here.c));
                puyoGroup.add(new Data(nx, ny, here.c));
            }
        }
        if (puyoGroup.size() >= 4) {
            for (Data d : puyoGroup) {
                a[d.x][d.y] = '.'; // 터짐
            }
            return true;
        }
        return false;
    }

    static void drop() {
        for (int j = 0; j < 6; j++) { // 각 열(column) 기준
            Queue<Character> queue = new ArrayDeque<>();

            // 1. 아래에서 위로 올라가면서 뿌요만 큐에 저장
            for (int i = 11; i >= 0; i--) {
                if (a[i][j] != '.') queue.add(a[i][j]);
            }

            // 2. 다시 아래에서부터 채우기
            for (int i = 11; i >= 0; i--) {
                if (!queue.isEmpty()) a[i][j] = queue.poll(); // 큐에서 꺼내서 채우기
                else a[i][j] = '.'; // 빈 공간 처리
            }
        }
    }

    static class Data {
        int x, y;
        char c;

        public Data(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}