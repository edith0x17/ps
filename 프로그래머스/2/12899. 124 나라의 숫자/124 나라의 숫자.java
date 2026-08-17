class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] a = {4, 1, 2};

        while (n > 0) {
            int r = n % 3;

            sb.append(a[r]);

            if (r == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }
        }

        return sb.reverse().toString();
    }
}