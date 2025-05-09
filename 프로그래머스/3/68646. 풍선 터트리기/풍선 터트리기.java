class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] prefixMin = new int[n];  // 왼쪽 최소값
        int[] suffixMin = new int[n];  // 오른쪽 최소값
        int answer = 0;

        // 왼쪽에서부터 prefixMin 계산
        prefixMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], a[i]);
        }

        // 오른쪽에서부터 suffixMin 계산
        suffixMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                // 양 끝 풍선은 무조건 생존 가능
                answer++;
            } else {
                // 둘 중 한쪽만 나보다 크면 생존 가능
                if (prefixMin[i - 1] > a[i] || suffixMin[i + 1] > a[i]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
