import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            System.out.println(checkPalindrome(s));
        }
    }
    static int checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) return 1;
                else return 2;
            }
        }
        return 0;
    }
    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }
}