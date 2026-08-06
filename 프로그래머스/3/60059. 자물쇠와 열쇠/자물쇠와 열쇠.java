class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int mapSize = n * 3;

        // lock 주변에 key가 움직일 여백을 만들기 위한 큰 배열
        int[][] map = new int[mapSize][mapSize];

        // lock을 큰 배열의 가운데에 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i + n][j + n] = lock[i][j];
            }
        }

        // 원본, 90도, 180도, 270도
        for (int r = 0; r < 4; r++) {

            // key의 왼쪽 위 좌표를 (x, y)에 둔다.
            for (int x = 0; x <= mapSize - m; x++) {
                for (int y = 0; y <= mapSize - m; y++) {

                    // 1. 현재 위치에 key를 올린다.
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            map[x + i][y + j] += key[i][j];
                        }
                    }

                    // 2. lock 영역이 모두 정확히 1이면 성공
                    if (check(map, n)) {
                        return true;
                    }

                    // 3. 다음 위치를 검사하기 위해 key를 다시 제거
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            map[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }

            // 다음 방향으로 90도 회전
            key = rotate(key);
        }

        return false;
    }

    static boolean check(int[][] map, int n) {
        // 가운데에 복사한 lock 영역만 확인
        for (int i = n; i < n * 2; i++) {
            for (int j = n; j < n * 2; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][n - 1 - i] = key[i][j];
            }
        }

        return ret;
    }
}