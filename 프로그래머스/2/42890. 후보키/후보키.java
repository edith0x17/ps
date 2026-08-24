import java.util.*;

class Solution {
    static int answer;
    static int l;
    static int[] ret;
    static List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        answer = 0;
        candidateKeys.clear();

        l = relation[0].length;

        for (int i = 1; i <= l; i++) {
            ret = new int[i];
            combi(0, 0, i, relation);
        }

        return answer;
    }

    static boolean check(int k, String[][] relation, int[] ret) {
        // 최소성
        HashSet<Integer> cur = new HashSet<>();

        for (int idx : ret) {
            cur.add(idx);
        }

        for (Set<Integer> key : candidateKeys) {
            if (cur.containsAll(key)) {
                return false;
            }
        }

        // 유일성
        HashSet<String> set = new HashSet<>();

        for (String[] s : relation) {
            String tmp = "";

            for (int idx : ret) {
                tmp += s[idx] + "#";
            }

            set.add(tmp);
        }

        if (set.size() != relation.length) {
            return false;
        }

        candidateKeys.add(cur);

        return true;
    }

    static void combi(int depth, int start, int k, String[][] relation) {
        if (depth == k) {
            if (check(k, relation, ret)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < l; i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1, k, relation);
        }
    }
}