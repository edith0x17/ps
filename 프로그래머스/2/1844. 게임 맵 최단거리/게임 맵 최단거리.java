import java.io.*;
import java.util.*;

class Solution {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        Queue<Data> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        q.offer(new Data(0, 0));
        while(!q.isEmpty()){
            Data data = q.poll();
            //
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                if(visited[nx][ny] != 0)continue;
                if(maps[nx][ny] == 0)continue;
                visited[nx][ny] = visited[data.x][data.y] + 1;
                q.offer(new Data(nx, ny));
            }
        }
        if(visited[n - 1][m - 1] == 0)return - 1;
        else return visited[n - 1][m - 1];
    }
    static class Data{
        int x, y;
        
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}