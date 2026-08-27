import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // 아직 사용하지 않은 숫자들
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // factorial[i] = i!
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        /*
         * 문제의 k는 1번째부터 시작
         * ArrayList index는 0부터 시작
         */
        k = k - 1;
        for (int i = 0; i < n; i++) {

            /*
             * 현재 자리를 하나 정했을 때
             * 뒤에서 만들 수 있는 순열 개수
             *
             * 첫째 자리 → (n-1)!
             * 둘째 자리 → (n-2)!
             * ...
             */
            long block = factorial[n - 1 - i];


            /*
             * 현재 k가 몇 번째 묶음에 있는지
             */
            int idx = (int) (k / block);


            /*
             * 그 묶음의 시작 숫자를 현재 자리에 선택
             */
            answer[i] = nums.get(idx);


            /*
             * 선택한 숫자는 이제 사용 못 함
             */
            nums.remove(idx);


            /*
             * 선택한 묶음 안에서 다시 몇 번째인지
             */
            k = k % block;
        }

        return answer;
    }
}