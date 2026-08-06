import java.util.*;

class Solution {
    static int n, price;
    static int[] discount = new int[]{10, 20, 30, 40};
    static int[] ret;

    public int[] solution(int[][] users, int[] emoticons) {
        ret = new int[emoticons.length];
        int[] answer = {};
        go(0, users, emoticons);
        answer = new int[]{n, price};
        return answer;
    }

    static void go(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            check(users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {//10, 20, 30, 40
            ret[depth] = discount[i];
            go(depth + 1, users, emoticons);
        }
    }

    static void check(int[][] users, int[] emoticons) {
        int nTmp = 0, priceTmp = 0;
        for (int[] user : users) {
            //users[0] 40, users[1] 10000
            int sum = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (ret[i] >= user[0]) {
                    sum += emoticons[i] * (100 - ret[i]) / 100;
                }
            }
            if (sum >= user[1]) nTmp++;
            else priceTmp += sum;
        }
        if (nTmp > n) {
            n = nTmp;
            price = priceTmp;
        } else if (nTmp == n) {
            if (priceTmp > price) {
                price = priceTmp;
            }
        }
    }
}