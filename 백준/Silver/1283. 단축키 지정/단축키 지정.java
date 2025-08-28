import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Set<Character> used = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();

            int pos = -1;
            //1
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (check(ch) && (i == 0 || s.charAt(i - 1) == ' ')) { //알파벳 && 단어의 첫 글자
                    char key = Character.toLowerCase(ch);
                    if (!used.contains(key)) {
                        pos = i;
                        used.add(key);
                        break;
                    }
                }
            }
            //2
            if (pos == -1) {
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (check(ch)) { //알파벳
                        char key = Character.toLowerCase(ch);
                        if (!used.contains(key)) {
                            pos = i;
                            used.add(key);
                            break;
                        }
                    }
                }
            }
            //3
            if (pos == -1) {
                answer.append(s);
                answer.append("\n");
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (i == pos) {
                        answer.append("[");
                        answer.append(s.charAt(i));
                        answer.append("]");
                    } else {
                        answer.append(s.charAt(i));
                    }
                }
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }

    static boolean check(char ch) {
        return 'A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z';
    }
}