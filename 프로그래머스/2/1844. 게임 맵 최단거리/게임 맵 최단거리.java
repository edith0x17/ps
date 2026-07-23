import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length, m = maps[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[0][0] = 1;
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == n - 1 && cur[1] == m - 1)break;
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;//범위
                if(visited[nx][ny] != 0)continue;//방문
                if(maps[nx][ny] == 0)continue;//장애물
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        if(visited[n - 1][m - 1] == 0)answer = -1;
        else answer = visited[n - 1][m - 1];
        return answer;
    }
}
//bfs visited push 