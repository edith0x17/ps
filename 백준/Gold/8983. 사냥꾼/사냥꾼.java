import java.io.*;
import java.util.*;

public class Main {
    static int m, n, l, answer;
    static int[] guns;
    static ArrayList<Data> animals = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        guns = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            guns[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new Data(x, y));
        }
        Arrays.sort(guns);
        for(Data data: animals){
            int remains = l - data.y;
            int left = data.x - remains;
            int right = data.x + remains;
            // left <= 사대의 위치 <= right
            int idx = Arrays.binarySearch(guns, left);
            if (idx < 0) idx = -(idx + 1);

            if (idx < guns.length && guns[idx] <= right) answer++;
        }
        System.out.println(answer);
    }
    static class Data{
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}