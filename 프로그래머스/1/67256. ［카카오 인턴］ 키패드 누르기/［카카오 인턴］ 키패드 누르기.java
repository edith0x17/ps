import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, int[]> mp = new HashMap<>();
        mp.put(1, new int[]{0, 0});
        mp.put(2, new int[]{0, 1});
        mp.put(3, new int[]{0, 2});

        mp.put(4, new int[]{1, 0});
        mp.put(5, new int[]{1, 1});
        mp.put(6, new int[]{1, 2});

        mp.put(7, new int[]{2, 0});
        mp.put(8, new int[]{2, 1});
        mp.put(9, new int[]{2, 2});

        mp.put(30, new int[]{3, 0});//*
        mp.put(0, new int[]{3, 1});//*
        mp.put(32, new int[]{3, 2});//#

        int[] l = new int[2];
        int[] r = new int[2];
        l[0] = 3;
        l[1] = 0;
        r[0] = 3;
        r[1] = 2;
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                int[] tmp = mp.get(i);
                l[0] = tmp[0];
                l[1] = tmp[1];
                sb.append("L");
            } else if (i == 3 || i == 6 || i == 9) {
                int[] tmp = mp.get(i);
                r[0] = tmp[0];
                r[1] = tmp[1];
                sb.append("R");
            } else {//2, 5, 8, 0
                int[] tmp = mp.get(i);
                int A = Math.abs(l[0] - tmp[0]) + Math.abs(l[1] - tmp[1]);
                int B = Math.abs(r[0] - tmp[0]) + Math.abs(r[1] - tmp[1]);
                if (A < B) {
                    l[0] = tmp[0];
                    l[1] = tmp[1];
                    sb.append("L");
                } else if (A > B) {
                    r[0] = tmp[0];
                    r[1] = tmp[1];
                    sb.append("R");
                } else {
                    if (hand.equals("left")) {
                        l[0] = tmp[0];
                        l[1] = tmp[1];
                        sb.append("L");
                    } else {
                        r[0] = tmp[0];
                        r[1] = tmp[1];
                        sb.append("R");
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}