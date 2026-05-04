import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int[] tmp = new int[command[1] - command[0] + 1];
            int j = 0;
            for (int i = command[0]; i <= command[1]; i++) {
                tmp[j++] = array[i - 1];
            }
            Arrays.sort(tmp);
            int k = command[2] - 1;
            answer[idx++] = tmp[k];
        }
        return answer;
    }
}