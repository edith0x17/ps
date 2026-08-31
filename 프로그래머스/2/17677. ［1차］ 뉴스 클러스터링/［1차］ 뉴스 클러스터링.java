import java.util.*;

class Solution {
    static int INF = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = "" + str1.charAt(i) + str1.charAt(i + 1);
            if ('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z' && 'A' <= tmp.charAt(1) && tmp.charAt(1) <= 'Z') {
                a.add(tmp);
            }
        }
        ArrayList<String> b = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = "" + str2.charAt(i) + str2.charAt(i + 1);
            if ('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z' && 'A' <= tmp.charAt(1) && tmp.charAt(1) <= 'Z') {
                b.add(tmp);
            }
        }

        int aSize = a.size(), bSize = b.size(), inter = 0;
        for (String s : a) {
            if (b.contains(s)) {
                inter++;
                b.remove(s);
            }
        }
        int union = aSize + bSize - inter;
        if (union == 0) return 65536;
        answer = (int) ((double) inter / union * 65536);
        return answer;
    }
}