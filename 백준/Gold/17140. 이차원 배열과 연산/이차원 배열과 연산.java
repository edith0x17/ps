import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int row = 3, col = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = 0;
        while (t <= 100) {
            if (r < row && c < col && arr[r][c] == k) {
                System.out.println(t);
                return;
            }
            if (row >= col) R();
            else C();
            t++;
        }
        System.out.println(-1);
    }

    static void R() {
        int maxCol = 0;
        int[][] temp = new int[101][101];
        for (int i = 0; i < row; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
            List<Data> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Data(key, map.get(key)));
            }
            Collections.sort(list);
            int idx = 0;
            for (Data d : list) {
                if (idx >= 100) break;
                temp[i][idx++] = d.num;
                if (idx >= 100) break;
                temp[i][idx++] = d.cnt;
            }
            maxCol = Math.max(maxCol, idx);
        }
        arr = temp;
        col = maxCol;
    }

    static void C() {
        int maxRow = 0;
        int[][] temp = new int[101][101];
        for (int j = 0; j < col; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < row; i++) {
                if (arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
            List<Data> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Data(key, map.get(key)));
            }
            Collections.sort(list);
            int idx = 0;
            for (Data d : list) {
                if (idx >= 100) break;
                temp[idx++][j] = d.num;
                if (idx >= 100) break;
                temp[idx++][j] = d.cnt;
            }
            maxRow = Math.max(maxRow, idx);
        }
        arr = temp;
        row = maxRow;
    }

    static class Data implements Comparable<Data> {
        int num, cnt;

        public Data(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            if (this.cnt == o.cnt) return Integer.compare(this.num, o.num);
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}