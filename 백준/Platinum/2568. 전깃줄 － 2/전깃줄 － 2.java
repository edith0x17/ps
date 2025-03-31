import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Data> arrayList = new ArrayList<>();
    static int[] arr, trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        trace = new int[n];
        StringTokenizer st = null;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.add(new Data(a, b));
        }
        Collections.sort(arrayList);
        for(int i = 0; i < n; i++){
            arr[i] = arrayList.get(i).b;
        }
        int answer = lis();
        System.out.println(n - answer);

        ArrayList<Integer> lisB = new ArrayList<>();
        int len = answer - 1;
        for(int i = n - 1; i >= 0; i--){
            if(trace[i] == len){
                lisB.add(arr[i]);
                len--;
            }
        }
        Set<Integer> lisSet = new HashSet<>(lisB);
        ArrayList<Integer> removeList = new ArrayList<>();
        for (Data d : arrayList) {
            if (!lisSet.contains(d.b)) {
                removeList.add(d.a);
            }
        }
        Collections.sort(removeList);
        for(int a : removeList){
            System.out.println(a);
        }
    }
    static int lis(){
        ArrayList<Integer> d = new ArrayList<>();
        d.add(arr[0]);
        trace[0] = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] > d.get(d.size() - 1)){
                d.add(arr[i]);
                trace[i] = d.size() - 1;
            }else{
                int pos = Collections.binarySearch(d, arr[i]);
                if(pos < 0) pos = -(pos + 1);
                d.set(pos, arr[i]);
                trace[i] = pos;
            }
        }
        return d.size();
    }
    static class Data implements Comparable<Data>{
        int a;
        int b;
        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Data o){
            return this.a - o.a;
        }
    }
}