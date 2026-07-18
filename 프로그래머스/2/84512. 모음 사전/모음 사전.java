import java.util.*;

class Solution {
    static int ans;
    static ArrayList<String> list = new ArrayList<>();
    static char[] vowel = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        go("");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i + 1;
            }
        }
        return ans;
    }

    static void go(String cur) {
        if (!cur.isEmpty()) {
            list.add(cur);
        }
        if (cur.length() == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            go(cur + vowel[i]);
        }
    }
}