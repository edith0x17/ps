import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String city : cities) {
            if (list.contains(city)) {
                answer += 1;
                list.remove(city);
                list.add(city);
            } else {
                answer += 5;
                if (list.size() < cacheSize) {
                    list.add(city);
                } else {
                    list.remove(list.get(0));
                    list.add(city);
                }
            }
        }
        return answer;
    }
}