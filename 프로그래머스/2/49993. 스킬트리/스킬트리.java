import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : skill.toCharArray()) {
            mp.put(ch, 1);
        }
        for (String s : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (mp.containsKey(ch)) sb.append(ch);
            }
            String tmp = sb.toString();
            if (skill.startsWith(tmp)) answer++;
        }
        return answer;
    }
}