class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        // 처음에는 그냥 오른쪽으로 끝까지 간다고 가정
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;
            answer += Math.min(up, down);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;//A가 아닌 문자의 인덱스
            }

            int front = i;
            int back = n - next;

            int case1 = front * 2 + back;
            int case2 = back * 2 + front;

            move = Math.min(move, Math.min(case1, case2));
        }
        // 문자 변경 횟수 + 커서 이동 횟수
        answer += move;
        return answer;
    }
}