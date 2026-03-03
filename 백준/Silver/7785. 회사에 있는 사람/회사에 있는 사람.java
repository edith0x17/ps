import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int n;
    static Map<String, String> mp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String flag = st.nextToken();
            mp.put(name, flag);
        }
        ArrayList<A> adj = new ArrayList<>();
        for (Map.Entry<String, String> entry : mp.entrySet()) {
            if (entry.getValue().equals("enter")) {
                adj.add(new A(entry.getKey()));
            }
        }
        Collections.sort(adj);
        for (A a : adj) {
            System.out.println(a.name);
        }
    }

    static class A implements Comparable<A> {
        String name;

        public A(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(A o) {
            //return this.name.compareTo(o.name);//오름차순
            return -this.name.compareTo(o.name);//내림차순
        }
    }
}