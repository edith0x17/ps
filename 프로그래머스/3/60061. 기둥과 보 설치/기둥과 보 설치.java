import java.util.*;

class Solution {
    static boolean[][] pillar;
    static boolean[][] beam;

    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 2][n + 2];
        beam = new boolean[n + 2][n + 2];

        // 1. 명령을 순서대로 처리
        for (int[] command : build_frame) {
            int x = command[0];
            int y = command[1];
            int type = command[2];   // 0: 기둥, 1: 보
            int action = command[3]; // 0: 삭제, 1: 설치

            if (type == 0) { // 기둥
                if (action == 1) { // 설치
                    pillar[x][y] = true;

                    // 설치 후 전체 구조가 잘못됐다면 원상복구
                    if (!check(n)) {
                        pillar[x][y] = false;
                    }
                } else { // 삭제
                    pillar[x][y] = false;

                    // 삭제 후 전체 구조가 잘못됐다면 원상복구
                    if (!check(n)) {
                        pillar[x][y] = true;
                    }
                }
            } else { // 보
                if (action == 1) { // 설치
                    beam[x][y] = true;

                    if (!check(n)) {
                        beam[x][y] = false;
                    }
                } else { // 삭제
                    beam[x][y] = false;

                    if (!check(n)) {
                        beam[x][y] = true;
                    }
                }
            }
        }

        // 2. 모든 명령이 끝난 후 남아 있는 구조물 수 계산
        int count = 0;

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) count++;
                if (beam[x][y]) count++;
            }
        }

        // 3. 정답 배열 생성
        int[][] answer = new int[count][3];
        int idx = 0;

        /*
         * 문제의 정렬 조건:
         * x 오름차순 → y 오름차순 → 기둥(0) 먼저, 보(1) 나중
         *
         * 따라서 x, y 순서로 돌면서
         * pillar를 먼저 넣고 beam을 넣으면 자동으로 정렬된다.
         */
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) {
                    answer[idx++] = new int[]{x, y, 0};
                }

                if (beam[x][y]) {
                    answer[idx++] = new int[]{x, y, 1};
                }
            }
        }

        return answer;
    }

    static boolean canPillar(int x, int y) {
        // 기둥: (x, y) -> (x, y + 1)

        // 바닥 위
        if (y == 0) return true;

        // 바로 아래 기둥 위
        if (pillar[x][y - 1]) return true;

        // 현재 좌표에서 오른쪽으로 뻗는 보의 왼쪽 끝 위
        if (beam[x][y]) return true;

        // 왼쪽에서 오는 보의 오른쪽 끝 위
        if (x > 0 && beam[x - 1][y]) return true;

        return false;
    }

    static boolean canBeam(int x, int y) {
        // 보: (x, y) -> (x + 1, y)

        // 왼쪽 끝 아래에 기둥
        if (y > 0 && pillar[x][y - 1]) return true;

        // 오른쪽 끝 아래에 기둥
        if (y > 0 && pillar[x + 1][y - 1]) return true;

        // 양쪽이 다른 보와 연결
        if (x > 0 && beam[x - 1][y] && beam[x + 1][y]) return true;

        return false;
    }

    static boolean check(int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y] && !canPillar(x, y)) {
                    return false;
                }

                if (beam[x][y] && !canBeam(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }
}