import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> mp = new HashMap<>();
        for (int w : weights) {
            double a = w * 1.0;
            double b = w * 1.0 / 2.0;
            double c = w * 2.0 / 3.0;
            double d = w * 3.0 / 4.0;
            if (mp.containsKey(a)) answer += mp.get(a);
            if (mp.containsKey(b)) answer += mp.get(b);
            if (mp.containsKey(c)) answer += mp.get(c);
            if (mp.containsKey(d)) answer += mp.get(d);
            
            mp.put(w * 1.0, mp.getOrDefault((w * 1.0), 0) + 1);
        }
        return answer;
    }
}