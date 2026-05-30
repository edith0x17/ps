import java.util.*;

class Solution {
    static HashMap<String, Integer> mp;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        for (int len : course) {
            mp = new HashMap<>();
            for (String order : orders) {
                if (order.length() < len) continue;

                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                combi(0, 0, len, new String(arr), "");
            }
            int mx = 0;
            for (int cnt : mp.values()) {
                if (cnt >= 2) mx = Math.max(mx, cnt);
            }
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                if (entry.getValue() == mx) result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    static void combi(int depth, int start, int len, String s, String tmp) {
        if (depth == len) {
            mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            combi(depth + 1, i + 1, len, s, tmp + s.charAt(i));
        }
    }
}