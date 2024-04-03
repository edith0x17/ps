import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Main{
    static class Data{
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    final static int dx1[] = {0, -1, 0, 1};
    final static int dy1[] = {1, 0, -1, 0};
    final static int dx2[] = {0, 1, 0, -1};
    final static int dy2[] = {1, 0, -1, 0};

    static int r, c, t, ret;
    static int[][] a = new int[54][54];
    static int[][] temp = new int[54][54];
    static ArrayList<Data> v1 = new ArrayList<>();
    static ArrayList<Data> v2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        boolean flag = true;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                
                if(a[i][j] == -1){
                    // 공기청정기 길
                    if(flag){
                        v1 = chung(i, j, dx1, dy1);
                        flag = false;
                    }else v2 = chung(i, j, dx2, dy2);
                }
            }
        }

        while(t-- > 0){
            // 미세먼지
            mise_go(dy1, dx1);
            // 공기청정기
            go(v1);
            go(v2);
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(a[i][j] != -1)ret += a[i][j];
            }
        }

        System.out.println(ret);
    }

    static void mise_go(int dx[], int dy[]){

        // fill
        for (int i = 0; i < r; i++){
            Arrays.fill(temp[i], 0);
        }

        // mise
        Queue<Data> q = new ArrayDeque<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(a[i][j] != -1 && a[i][j] > 0)q.offer(new Data(i, j));
            }
        }

        // spread
        while(q.size() > 0){
            int x, y;
            x = q.peek().x; y = q.peek().y;
            q.poll();

            int spread = a[x][y] / 5;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || a[nx][ny] == -1) continue; // 범위 || 공기청정기

                temp[nx][ny] += spread;
                a[x][y] -= spread;
            }
        }

        //
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                a[i][j] += temp[i][j];
            }
        }
    }

    static void go(ArrayList<Data> v){
        for(int i = v.size() - 1; i > 0; i--){
            a[v.get(i).x][v.get(i).y] =  a[v.get(i - 1).x][v.get(i - 1).y];
        }

        a[v.get(0).x][v.get(0).y] = 0;
        return;
    }

    // 공기청정기 길
    static ArrayList<Data> chung(int sx, int sy, int dx[], int dy[]){
        ArrayList<Data> v = new ArrayList<>();
        int cnt = 0;
        int x = sx;
        int y = sy;

        while(true){
            int nx = x + dx[cnt];
            int ny = y + dy[cnt];

            if(nx == sx && ny == sy)break;

            if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                cnt++;
                nx = x + dx[cnt];
                ny = y + dy[cnt];
            }

            if(nx == sx && ny == sy)break;

            x = nx;
            y = ny;
            v.add(new Data(nx, ny));
        }

        return v;
    }
}