import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        HashMap<String, Integer> all = new HashMap<>();
        HashMap<String, Integer> buy = new HashMap<>();
        for (String gem : gems) {
            all.put(gem, all.getOrDefault(gem, 0) + 1);
        }
        int n = all.size();
        int l = 0, r = 0, len = Integer.MAX_VALUE;
        while (true) {
            if (buy.size() == n) {
                String gem = gems[l];
                buy.put(gem, buy.get(gem) - 1);
                if (buy.get(gem) == 0) {
                    buy.remove(gem);
                }
                l++;
            } else if (r == gems.length) {
                break;
            } else {
                buy.put(gems[r], buy.getOrDefault(gems[r], 0) + 1);
                r++;
            }

            if (buy.size() == n) {
                if (r - l < len) {
                    len = r - l;
                    answer = new int[]{l + 1, r - 1 + 1};
                }
            }
        }
        return answer;
    }
}