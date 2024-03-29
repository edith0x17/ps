import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Data{
    int x;
    int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    final static int INF = 987654321;
    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1};
    static int r, c, ret, x, y, sx, sy;;
    static char[][] a = new char[1004][1004];
    static int[][] fire = new int[1004][1004];
    static int[][] person = new int[1004][1004];
    static Queue<Data> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {

        // init, 불이 없을 경우,,,
        for(int i = 0; i < 1004; i++){
            for(int j = 0; j < 1004; j++){
                fire[i][j] = INF;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // input
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                a[i][j] = s.charAt(j);

                char ch = a[i][j];
                if(ch == 'J'){
                    sx = i; sy = j;
                }else if(ch == 'F'){
                    fire[i][j] = 1;
                    q.offer(new Data(i, j));
                }
            }
        }

        // fire first
        while(!q.isEmpty()){
            x = q.peek().x; y = q.peek().y;
            q.poll();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c)continue; // 범위
                if (fire[nx][ny] != INF || a[nx][ny] == '#') continue; // 방문 || 벽
                fire[nx][ny] = fire[x][y] + 1;
                q.offer(new Data(nx, ny));
            }
        }

        // person second
        person[sx][sy] = 1;
        q.offer(new Data(sx, sy));
        while(!q.isEmpty()){
            x = q.peek().x; y = q.peek().y;
            q.poll();

            // check
            if(x == r - 1 || x == 0 || y == c - 1 || y == 0){
                ret = person[x][y];
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c)continue; // 범위
                if (person[nx][ny] != 0 || a[nx][ny] == '#') continue; // 방문 || 벽

                // 불 > 사람 + 1 -> 갈 수 있다,,,
                if (fire[nx][ny] > person[x][y] + 1){
                    person[nx][ny] = person[x][y] + 1;
                    q.offer(new Data(nx, ny));
                }
            }
        }

        // answer
        if (ret != 0) System.out.println(ret);
        else System.out.println("IMPOSSIBLE");
    }
}