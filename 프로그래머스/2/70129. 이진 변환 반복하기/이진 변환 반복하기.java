import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cntAll = 0;  // 변환 횟수
        int cnt = 0;     // 제거한 0의 개수

        while (!s.equals("1")) {
            int zeroCount = 0;
            StringBuilder sb = new StringBuilder();

            // 0 제거 및 0 개수 세기
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    cnt++;
                } else {
                    sb.append(c);
                }
            }
            
            s = Integer.toBinaryString(sb.length()); // 이진수로 변환
            cntAll++;
        }

        return new int[]{cntAll, cnt};
    }
}