import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, sum = 987654321;
    static ArrayList<Data> homeList = new ArrayList<>();
    static ArrayList<Data> chickenList = new ArrayList<>();
    static ArrayList<Data> cc = new ArrayList<>();
    static ArrayList<Integer> bb = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) chickenList.add(new Data(i, j)); // 치킨집
                else if (num == 1) homeList.add(new Data(i, j)); // 집
            }
        }

        combi(-1, bb);

        System.out.println(sum);

    }

    static void go() {
        int sumsum = 0;
        for (Data h : homeList) {
            int distance = Integer.MAX_VALUE; // 최대값으로 초기화

            for (Data chicken : cc) {
                distance = Math.min(distance, Math.abs(h.x - chicken.x) + Math.abs(h.y - chicken.y));
            }

            sumsum += distance;
        }

        sum = Math.min(sum, sumsum);
    }

    static void combi(int start, ArrayList<Integer> b) {
        if (b.size() == m) {
            for (int j : b) {

//                int tempX = chickenList.get(j).x;
//                int tempY = chickenList.get(j).y;
//                cc.add(new Data(tempX, tempY));
                cc.add(chickenList.get(j));
            }

            // cc로 로직
            go();
            cc.clear();
            return;
        }

        for (int i = start + 1; i < chickenList.size(); i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    static class Data {
        int x;
        int y;

        public Data() {
        }

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}