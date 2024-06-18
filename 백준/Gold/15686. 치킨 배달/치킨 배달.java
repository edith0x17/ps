import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static class Data{
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m, ans = 987654321;
    static int[][] a;
    static int[] ret;
    static ArrayList<Data> home = new ArrayList<>();
    static ArrayList<Data> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        Data[] chi = new Data[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] == 1)home.add(new Data(i, j)); // 집
                else if(a[i][j] == 2)chicken.add(new Data(i, j)); // 치킨집
            }
        }

        combi(0, 0, chi);

        sb.append(ans);

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    static int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int go(Data[] chi){
        int ret = 0;
        for(int i = 0; i < home.size(); i++){
            int mi = 987654321;
            for(int j = 0; j < chi.length; j++){
                mi = Math.min(mi, dist(home.get(i).x, home.get(i).y, chi[j].x, chi[j].y));
            }
            ret += mi;
        }

        return ret;
    }

    static void combi(int start, int idx, Data[] chi){
        if(idx == m){
            ans = Math.min(ans, go(chi));
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            chi[idx] = chicken.get(i);
            combi(i + 1, idx + 1, chi);
        }
    }
}