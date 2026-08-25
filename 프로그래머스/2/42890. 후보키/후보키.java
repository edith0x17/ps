import java.util.*;

class Solution {
    static int answer;
    static int l;
    static int[] ret;
    static ArrayList<HashSet<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        l = relation[0].length;
        for (int i = 1; i <= l; i++) {
            ret = new int[i];
            combi(0, 0, i, relation);
        }
        return answer;
    }

    static boolean check(String[][] relation) {
        HashSet<Integer> cur = new HashSet<>();
        for (int i : ret) {
            cur.add(i);
        }
        for (HashSet<Integer> i : candidateKeys) {
            if (cur.containsAll(i)) return false;
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String tmp = "";
            for (int j : ret) {
                tmp += relation[i][j] + "#";
            }
            set.add(tmp);
        }
        if (set.size() != relation.length) return false;
        candidateKeys.add(cur);
        return true;
    }

    static void combi(int depth, int start, int k, String[][] relation) {
        if (depth == k) {
            //ret
            if (check(relation)) answer++;
            return;
        }

        for (int i = start; i < l; i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1, k, relation);
        }
    }
}