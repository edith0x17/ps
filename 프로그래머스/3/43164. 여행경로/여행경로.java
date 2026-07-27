import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] route, answer;
    static boolean found;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        visited = new boolean[tickets.length];
        route = new String[tickets.length + 1];
        route[0] = "ICN";

        dfs(0, "ICN", tickets);

        return answer;
    }

    static void dfs(int depth, String current, String[][] tickets) {
        if (found) return;

        if (depth == tickets.length) {
            answer = route.clone();
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) continue;
            if (!tickets[i][0].equals(current)) continue;

            visited[i] = true;
            route[depth + 1] = tickets[i][1];

            dfs(depth + 1, tickets[i][1], tickets);

            visited[i] = false;
        }
    }
}