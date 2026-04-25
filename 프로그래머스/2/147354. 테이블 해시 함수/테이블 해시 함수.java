import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        ArrayList<Data> list = new ArrayList<>();
        for (int[] d : data) {
            list.add(new Data(d, col - 1));
        }
        Collections.sort(list);

        for (int i = row_begin - 1; i < row_end; i++) {
            Data cur = list.get(i);

            int sum = 0;
            for (int j : cur.a) {
                sum += (j % (i + 1));
            }
            answer ^= sum;
        }
        return answer;
    }

    static class Data implements Comparable<Data> {
        int[] a;
        int col;

        public Data(int[] a, int col) {
            this.a = a;
            this.col = col;
        }

        @Override
        public int compareTo(Data o) {
            if (this.a[col] == o.a[col]) return Integer.compare(o.a[0], this.a[0]);//내림차순
            return Integer.compare(this.a[col], o.a[col]);//오름차순
        }
    }
}