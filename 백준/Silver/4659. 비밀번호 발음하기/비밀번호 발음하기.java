import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            s = br.readLine();
            if (s.equals("end")) break;

            if (isAcceptable(s)) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    static boolean isAcceptable(String s) {
        boolean hasVowel = false; // 최소 하나의 모음 포함 여부
        int consecutiveCount = 0; // 연속된 모음/자음 카운트
        char prev = '.'; // 이전 문자 (초기값)

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (isVowel(current)) {
                hasVowel = true;
            }

            if (isVowel(current) != isVowel(prev)) {
                consecutiveCount = 1; // 모음/자음이 변경되면 카운트 초기화
            } else {
                consecutiveCount++;
            }

            // 조건 3: 같은 글자가 두 번 연속되면 안 됨 ("ee", "oo"는 예외)
            if (prev == current && current != 'e' && current != 'o') {
                return false;
            }

            // 조건 2: 모음 또는 자음이 3번 연속되면 안 됨
            if (consecutiveCount > 2) {
                return false;
            }
            prev = current;
        }
        return hasVowel; // 최소 하나의 모음이 포함되어야만 true 반환
    }
}