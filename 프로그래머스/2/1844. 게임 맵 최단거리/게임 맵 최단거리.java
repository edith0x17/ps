import java.io.*;
import java.util.*;

class Solution {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m, answer = -1;
    static int[][] visited;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        bfs(0, 0, maps);
        if(visited[n - 1][m - 1] != 0)answer = visited[n - 1][m - 1];
        return answer;
    }
    static void bfs(int x, int y, int[][] maps){
        Queue<Data> q = new ArrayDeque<>();
        
        visited[x][y] = 1;
        q.offer(new Data(x, y));
        while(!q.isEmpty()){
            Data data = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;// 범위
                if(maps[nx][ny] == 0 || visited[nx][ny] != 0)continue;// 장애물 || 방문
                visited[nx][ny] = visited[data.x][data.y] + 1;
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