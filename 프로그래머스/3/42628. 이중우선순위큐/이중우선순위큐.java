import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String s : operations) {
            String[] ss = s.split(" ");
            int num = Integer.parseInt(ss[1]);
            if (ss[0].equals("I")) {//I
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {//D
                if (map.isEmpty()) continue;

                int key = (num == 1) ? map.lastKey() : map.firstKey();//최댓값 : 최솟값
                if (map.get(key) == 1) map.remove(key);
                else map.remove(key);
            }
        }
        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}