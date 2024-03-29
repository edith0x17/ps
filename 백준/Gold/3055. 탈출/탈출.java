import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Data{
    int x;
    int y;

    public Data(){

    }
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int r, c;
    static char[][] a;
    static int [][] visited;
    static Queue<Data> waterQ = new ArrayDeque<>(); // 물
    static Queue<Data> queue = new ArrayDeque<>(); // 고슴도치
    static Data ret;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new char[r + 4][c + 4];
        visited = new int[r + 4][c + 4];

        for(int i = 0; i < r; i++){

            String s = br.readLine();
            for(int j = 0; j < c; j++){
                a[i][j] = s.charAt(j);
                char ch = a[i][j];
                if(ch == '*'){ // 물
                    visited[i][j] = 1;
                    waterQ.offer(new Data(i, j));
                }else if(ch == 'S'){ // 고슴도치
                    visited[i][j] = 1;
                    queue.offer(new Data(i, j));
                }else if(ch == 'D'){ // 비버의 굴
                    ret = new Data(i, j);
                }
            }
        }

        bfs();

        // outPut
        if(visited[ret.x][ret.y] != 0) System.out.println(visited[ret.x][ret.y] - 1);
        else System.out.println("KAKTUS");
    }

    static void bfs(){

        while(!queue.isEmpty()){

            // 물 이동
            int S = waterQ.size();
            for(int k = 0; k < S; k++){
                int x = waterQ.peek().x; int y = waterQ.peek().y;
                waterQ.poll();

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] != 0)continue; // 범위 || 방문
                    if(a[nx][ny] == 'X')continue; // 돌
                    if(a[nx][ny] == 'D')continue; // 비버의 굴

                    visited[nx][ny] = 1;
                    waterQ.offer(new Data(nx, ny));
                }
            }
            
            // 고슴도치 이동
            int ss = queue.size();
            for(int k = 0; k < ss; k++){
                int x = queue.peek().x; int y = queue.peek().y;
                queue.poll();

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] != 0)continue; // 범위 || 방문
                    if(a[nx][ny] == 'X')continue; // 돌
                    if(a[nx][ny] == '*')continue; // 물
                    
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new Data(nx, ny));
                }
            }
        }

    }
}