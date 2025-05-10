import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> adj = new ArrayList<>();

        // 1. 각 작업의 완료까지 남은 일수 계산 → 큐에 삽입
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] != 0) day++;
            queue.offer(day); // 예: [7, 3, 9]
        }

        // 2. 배포 단위로 묶음 계산
        while (!queue.isEmpty()) {
            int base = queue.poll(); // 현재 기준 배포일
            int count = 1;

            // 다음 작업들도 base보다 작거나 같으면 같이 배포
            while (!queue.isEmpty() && queue.peek() <= base) {
                queue.poll(); // 함께 배포
                count++;
            }

            adj.add(count); // 이 묶음에 몇 개 배포됐는지 기록
        }
        int[] answer = new int[adj.size()];
        int idx = 0;
        for(int i: adj){
            answer[idx++] = i;
        }
        // 3. List → 배열 변환
        return answer;
    }
}
