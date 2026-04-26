class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int retA = getGCD(arrayA);
        int retB = getGCD(arrayB);

        int answer = 0;

        if (check(retA, arrayB)) answer = Math.max(answer, retA);
        if (check(retB, arrayA)) answer = Math.max(answer, retB);

        return answer;
    }

    static boolean check(int gcd, int[] arr) {
        for (int x : arr) {
            if (x % gcd == 0) return false;
        }
        return true;
    }

    static int getGCD(int[] array) {
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = gcd(ret, array[i]);
        }
        return ret;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}