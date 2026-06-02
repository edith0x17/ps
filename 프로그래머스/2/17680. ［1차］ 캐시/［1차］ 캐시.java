import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        ArrayList<String> cache = new ArrayList<>();
        for (String city : cities) {
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() < cacheSize) {
                    cache.add(city);
                } else {
                    cache.remove(cache.get(0));
                    cache.add(city);
                }
            }
        }
        return answer;
    }
}