import java.io.*;
import java.util.*;

class Solution {
    static int w, l;
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++){
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            w = Math.max(w, a);
            l = Math.max(l, b);
        }
        answer = w * l;
        return answer;
    }
}