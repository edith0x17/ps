import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int[] ret = go(k);
        int n = ret.length - 1;

        double[] prefix = new double[ret.length];

        for (int i = 1; i < ret.length; i++) {
            double area = (ret[i - 1] + ret[i]) / 2.0;
            prefix[i] = prefix[i - 1] + area;
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }

    static int[] go(int k) {
        ArrayList<Integer> list = new ArrayList<>();

        while (k != 1) {
            list.add(k);
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
        }

        list.add(1);

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }
}