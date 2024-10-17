import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class BabyShark {
        int x, y;
        int size;
        int cnt;

        BabyShark(int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }

    static class Data implements Comparable<Data> {
        int x, y;
        int size; // 먹이의 크기
        int distance; // 아기 상어로부터의 거리

        @Override
        public int compareTo(Data o) {
            // 거리가 같을 때 x 좌표, y 좌표를 비교해서 우선순위를 정함
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return this.y - o.y; // y 좌표가 더 작은 쪽 우선
                }
                return this.x - o.x; // x 좌표가 더 작은 쪽 우선
            }
            return this.distance - o.distance; // 거리가 더 짧은 쪽 우선
        }

        Data(int x, int y, int size, int distance) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.distance = distance;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] a, visited;
    static BabyShark babyShark = null;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        a = new int[n][n]; // 아기 상어의 활동 공간 크기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 9) { // 아기 상어의 초기 위치
                    babyShark = new BabyShark(i, j, 2, 0);
                    a[i][j] = 0; // 아기 상어가 있는 위치는 비워둠
                }
            }
        }

        while (true) {
            PriorityQueue<Data> pq = new PriorityQueue<>();  // 첫 번째 큐: BFS 탐색용
            PriorityQueue<Data> pq2 = new PriorityQueue<>(); // 두 번째 큐: 먹이 선택용
            visited = new int[n][n]; // 방문 배열 초기화
            pq.offer(new Data(babyShark.x, babyShark.y, 2, 0)); // 아기 상어의 초기 위치
            visited[babyShark.x][babyShark.y] = 1;

            // 1. BFS 탐색 진행 (첫 번째 큐 사용)
            while (!pq.isEmpty()) {
                Data current = pq.poll(); // 현재 위치 정보 꺼냄

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    // 2. 범위 확인 및 조건에 맞지 않는 경우 건너뜀
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] != 0) continue; // 범위 || 방문
                    if (a[nx][ny] > babyShark.size) continue; // 상어보다 큰 물고기인 경우 이동 불가

                    pq.offer(new Data(nx, ny, a[nx][ny], visited[current.x][current.y] + 1)); // 다음 탐색을 위해 큐에 넣음
                    visited[nx][ny] = visited[current.x][current.y] + 1; // 방문 체크

                    // 3. 먹을 수 있는 물고기만 두 번째 큐에 넣음
                    if (a[nx][ny] > 0 && a[nx][ny] < babyShark.size) { // 물고기가 있고 크기가 상어보다 작은 경우
//                        pq2.offer(new Data(nx, ny, a[nx][ny], visited[nx][ny] - 1)); // 먹이 후보
                        pq2.offer(new Data(nx, ny, a[nx][ny], visited[current.x][current.y] + 1)); // 먹이 후보
                    }
                }
            }

            // 4. 먹을 수 있는 물고기가 없으면 종료
            if (pq2.isEmpty()) break;

            // 5. 두 번째 큐에서 가장 적절한 먹이를 선택 (가장 가까운 거리, x/y 좌표 순)
            Data target = pq2.poll(); // 가장 우선순위 높은 먹이 선택
            a[target.x][target.y] = 0; // 먹은 물고기 자리 비워줌
            babyShark.x = target.x; // 아기 상어 위치 업데이트
            babyShark.y = target.y;
            answer += target.distance - 1; // 이동한 거리 추가
            babyShark.cnt++; // 먹은 횟수 증가

            // 6. 아기 상어가 자신의 크기만큼 먹으면 크기 증가
            if (babyShark.cnt == babyShark.size) {
                babyShark.size++;
                babyShark.cnt = 0;
            }
        }
        System.out.println(answer); // 결과 출력
    }
}