import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (String operation : operations) {
            String[] tmp = operation.split(" ");
            int num = Integer.parseInt(tmp[1]);//num, 1, -1
            if (tmp[0].equals("I")) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            } else {
                if (mp.isEmpty()) continue;//사이즈
                
                if (num == 1) {
                    int mx = mp.lastKey();//최대
                    int cnt = mp.get(mx);
                    if (cnt - 1 == 0) mp.remove(mx);
                    else mp.put(mx, cnt - 1);
                } else {//-1
                    int mi = mp.firstKey();//최소
                    int cnt = mp.get(mi);
                    if (cnt - 1 == 0) mp.remove(mi);
                    else mp.put(mi, cnt - 1);
                }
            }
        }
        if (mp.isEmpty()) return new int[]{0, 0};
        else return new int[]{mp.lastKey(), mp.firstKey()};
    }
}