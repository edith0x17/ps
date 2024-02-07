import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] a = new int[1004][1004];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int k = 0; k < n; k++){
            int y, x;
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            // x행 y열
            for(int i = x; i < x + 10; i++ ){
                for(int j = y; j < y + 10; j++){
                    if(i < 0 || i >= 100 || j < 0 || j >= 100)continue;

                    a[i][j] = 1;
                }
            }
        }

        int ret = 0;

        for(int i = 0; i < 100; i++ ){
            for(int j = 0; j < 100; j++){

                if(a[i][j] == 1){

                    for(int k = 0; k < 4; k++){

                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(a[nx][ny] == 0 || nx < 0 || nx >= 100 || ny < 0 || ny >= 100)ret++; // 0인 부분 카운트 || 범위 초과 부분 카운트

                    }
                }
            }
        }

        sb.append(ret);
        System.out.println(sb);

    }
}
