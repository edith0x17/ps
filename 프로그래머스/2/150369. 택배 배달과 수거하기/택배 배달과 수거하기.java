import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = n - 1;
        int p = n - 1;
        while (d >= 0 || p >= 0) {
            // 1. 뒤에서부터 이미 처리된 집 건너뛰기
            while (d >= 0 && deliveries[d] == 0) {
                d--;
            }
            while (p >= 0 && pickups[p] == 0) {
                p--;
            }
            // 2. 둘 다 끝났으면 종료
            if (d < 0 && p < 0) {
                break;
            }

            // 3. 이번 왕복에서 가장 멀리 가야 하는 집
            int far = Math.max(p, d);

            answer += (long) (far + 1) * 2;


            // 4. 이번 왕복에서 배달할 수 있는 남은 용량
            int remain = cap;

            while (d >= 0 && remain > 0) {

                // 현재 집의 배달을 전부 처리할 수 있다면
                if (deliveries[d] <= remain) {

                    remain -= deliveries[d];
                    deliveries[d] = 0;
                    d--;

                } else {

                    // 현재 집의 일부만 처리
                    deliveries[d] -= remain;
                    remain = 0;
                }
            }


            // 5. 이번 왕복에서 수거할 수 있는 남은 용량
            remain = cap;

            while (p >= 0 && remain > 0) {

                if (pickups[p] <= remain) {

                    remain -= pickups[p];
                    pickups[p] = 0;
                    p--;

                } else {

                    pickups[p] -= remain;
                    remain = 0;
                }
            }
        }

        return answer;
    }
}