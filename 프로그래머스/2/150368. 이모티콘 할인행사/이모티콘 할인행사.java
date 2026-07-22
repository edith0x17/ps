import java.util.*;

class Solution {
    static int mxCnt, mxPrice;
    static int n;
    static int[] discount = new int[]{10, 20, 30, 40};
    static int[] ret;

    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        ret = new int[n];
        go(0, users, emoticons);
        return new int[]{mxCnt, mxPrice};
    }

    static void go(int depth, int[][] users, int[] emoticons) {
        if (depth == n) {
            int cnt = 0, price = 0;
            for (int[] user : users) {
                int tmpPrice = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (discount[ret[i]] >= user[0]) {
                        tmpPrice += emoticons[i] * (100 - discount[ret[i]]) / 100;
                    }
                }
                if (tmpPrice >= user[1]) cnt++;
                else price += tmpPrice;
            }
            if (cnt > mxCnt) {
                mxCnt = cnt;
                mxPrice = price;
            } else if (cnt == mxCnt) {
                mxPrice = Math.max(mxPrice, price);
            }
            System.out.println(mxCnt + " " + mxPrice);
            return;
        }

        for (int i = 0; i < 4; i++) {//중복순열
            ret[depth] = i;
            go(depth + 1, users, emoticons);
        }
    }
}