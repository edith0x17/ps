import java.util.*;

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        ArrayList<Integer> adj = new ArrayList<>();
        for (String sss : ss) {
            adj.add(Integer.parseInt(sss));
        }
        Collections.sort(adj);
        String answer = "";
        answer += adj.get(0) + " ";
        answer += adj.get(adj.size() - 1);
        return answer;
    }
}