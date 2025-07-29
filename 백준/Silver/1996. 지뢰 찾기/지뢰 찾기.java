import java.io.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '.') {
                    sb.append('*');
                } else {
                    int sum = 0;
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        
                        if (map[nx][ny] != '.' && map[nx][ny] != '*') {
                            sum += map[nx][ny] - '0';
                        }
                    }
                    if (sum >= 10) sb.append('M');
                    else sb.append((char) (sum + '0'));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}