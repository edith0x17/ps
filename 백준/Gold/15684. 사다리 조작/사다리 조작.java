import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선 개수
        M = Integer.parseInt(st.nextToken()); // 가로선 개수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치 개수

        map = new boolean[H + 1][N + 1]; // 가로선 정보 저장 (1-based index)

        // 기존 가로선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 가로선 위치 (row)
            int b = Integer.parseInt(st.nextToken()); // 세로선 위치 (col)
            map[a][b] = true;
        }

        // 0개, 1개, 2개, 3개 추가하는 경우 DFS 탐색
        for (int i = 0; i <= 3; i++) {
            dfs(0, i);
            if (answer != Integer.MAX_VALUE) break; // 최소 개수를 찾으면 종료
        }

        // 정답 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 🔹 DFS: 사다리를 하나씩 추가하며 체크
    static void dfs(int count, int maxCount) {
        if (count == maxCount) {
            if (check()) answer = Math.min(answer, count);
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                // 가로선이 이미 존재하면 스킵
                if (map[i][j] || map[i][j - 1] || map[i][j + 1]) continue;

                // 가로선 추가
                map[i][j] = true;
                dfs(count + 1, maxCount);
                map[i][j] = false; // 백트래킹 (원래 상태로 복구)
            }
        }
    }

    // 🔹 사다리 결과가 올바른지 체크
    static boolean check() {
        for (int start = 1; start <= N; start++) { // 각 세로선마다 검사
            int col = start; // 현재 세로선

            for (int row = 1; row <= H; row++) {
                if (map[row][col]) col++; // 오른쪽 이동
                else if (col > 1 && map[row][col - 1]) col--; // 왼쪽 이동
            }

            // 시작과 도착이 다르면 실패
            if (col != start) return false;
        }
        return true;
    }
}