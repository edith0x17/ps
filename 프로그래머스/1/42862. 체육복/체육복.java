import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // Step 1: 여벌 체육복을 가진 학생이 도난당한 경우 처리
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r); // 도난당했지만 여벌이 있는 학생
            } else {
                reserveSet.add(r); // 순수한 여벌 학생
            }
        }

        // Step 2: 남은 lost 학생들에 대해 여벌 빌리기
        int answer = n - lostSet.size(); // 기본적으로 체육복 있는 학생 수
        
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1); // 왼쪽 학생이 여벌 빌려줌
                answer++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1); // 오른쪽 학생이 여벌 빌려줌
                answer++;
            }
        }
        
        return answer;
    }
}
