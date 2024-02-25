import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int v, e;
    static int[] p;
    static Node[] nodes;

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int c;

        public Node() {
        }

        public Node(int from, int to, int c) {
            this.from = from;
            this.to = to;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        p = new int[v + 4];
        for (int i = 1; i <= v; i++) p[i] = i; // make set

        nodes = new Node[e];

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(f, t, c);
        }

        Arrays.sort(nodes);

        int ret = 0;
        for(int i = 0; i < e; i++){

            int t1 = Find(nodes[i].from);
            int t2 = Find(nodes[i].to);

            if(t1 != t2){ // 다른 그룹이면 Union
                Union(t1, t2);
                ret += nodes[i].c;
            }
        }

        System.out.println(ret);
    }

    static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        p[y] = p[x];
    }

    static int Find(int x){
        if(x == p[x])return x;
        else return p[x] = Find(p[x]);
    }
}