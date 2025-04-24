import java.io.*;
import java.util.*;

class Solution {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    static int n, m;
    static char[][] a;
    static boolean[][] visited;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        a = new char[n + 2][m + 2];
        for(int i = 0; i < n + 2; i++){
            Arrays.fill(a[i], '0');
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        for(int i = 0; i < requests.length; i++){
            visited = new boolean[n + 2][m + 2];
            bfs();
            if(requests[i].length() == 1){
                remove(requests[i].charAt(0));
            }else{
                removeAll(requests[i].charAt(0));
            }
        }
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                if(a[i][j] == '0')continue;
                answer++;
            }
        }
        return answer;
    }
    static void remove(char ch){
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                if(a[i][j] == ch && check(i, j))a[i][j] = '0';
            }
        }
    }
    static void removeAll(char ch){
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                if(a[i][j] == ch)a[i][j] = '0';
            }
        }
    }
    static boolean check(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) return true;
        }
        return false;
    }
    static void bfs(){
        Queue<Data> q = new ArrayDeque();
        visited[0][0] = true;
        q.offer(new Data(0, 0));
        while(!q.isEmpty()){
            Data data = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (nx < 0 || nx >= n + 2 || ny < 0 || ny >= m + 2) continue;
                if (a[nx][ny] != '0') continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Data(nx, ny));
            }
        }
    }
    static class Data{
        int x, y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}