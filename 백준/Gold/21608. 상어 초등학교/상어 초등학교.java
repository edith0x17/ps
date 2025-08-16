import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] seat;
    static boolean[][] likes; //likes[s][x] = s가 x를 좋아하면 true
    static int[] order;     
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        int total = N * N;
        seat = new int[N][N];
        likes = new boolean[401][401];
        order = new int[total];
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            order[i] = s;
            for (int k = 0; k < 4; k++) {
                int f = Integer.parseInt(st.nextToken());
                likes[s][f] = true;
            }
        }

        for (int idx = 0; idx < total; idx++) {
            int s = order[idx];

            int bestR = -1, bestC = -1;
            int bestLike = -1, bestEmpty = -1;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (seat[r][c] != 0) continue; // 이미 찼으면 skip

                    int likeCnt = 0, emptyCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d], nc = c + dc[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (seat[nr][nc] == 0) emptyCnt++;
                        else if (likes[s][seat[nr][nc]]) likeCnt++;
                    }

                    // 조건 1 → 2 → 3 (행) → 4 (열) 비교
                    if (likeCnt > bestLike
                            || (likeCnt == bestLike && emptyCnt > bestEmpty)
                            || (likeCnt == bestLike && emptyCnt == bestEmpty && (bestR == -1 || r < bestR))
                            || (likeCnt == bestLike && emptyCnt == bestEmpty && r == bestR && c < bestC)) {
                        bestLike = likeCnt;
                        bestEmpty = emptyCnt;
                        bestR = r;
                        bestC = c;
                    }
                }
            }
            seat[bestR][bestC] = s;
        }

        int[] scoreMap = {0, 1, 10, 100, 1000};
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int s = seat[r][c];
                int likeCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (likes[s][seat[nr][nc]]) likeCnt++;
                }
                answer += scoreMap[likeCnt];
            }
        }
        System.out.println(answer);
    }
}