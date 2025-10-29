import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int n;
    static boolean[][] visited;
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        List<List<Data>> emptySpaces = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(game_board[i][j] == 0 && !visited[i][j]){
                    emptySpaces.add(extractSpaces(i, j, game_board, 0));
                }
            }
        }
        List<List<Data>> puzzlePieces = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(table[i][j] == 1 && !visited[i][j]){
                    puzzlePieces.add(extractSpaces(i, j, table, 1));
                }
            }
        }
        int answer = 0;
        boolean[] used = new boolean[puzzlePieces.size()];
        for(List<Data> emptySpace :emptySpaces){
            //emptySpace <- puzzlePieces
            for(int i = 0; i < puzzlePieces.size(); i++){
                if(used[i])continue;
                
                List<Data> puzzlePiece = puzzlePieces.get(i);
                for(int d = 0; d < 4; d++){
                    puzzlePiece = rotate(puzzlePiece);
                    if(check(emptySpace, puzzlePiece)){
                        answer += puzzlePiece.size();
                        used[i] = true;
                        break;
                    }
                }
                if(used[i])break;
            }
        }
        return answer;
    }
    
    static boolean check(List<Data> a, List<Data> b){
        if(a.size() != b.size())return false;
        for(int i = 0; i < a.size(); i++){
            if((a.get(i).x != b.get(i).x) || a.get(i).y != b.get(i).y)return false;
        }
        return true;
    }
    
    static List<Data> rotate(List<Data> adj){
        List<Data> rotated = new ArrayList<>();
        for(Data d: adj){
            rotated.add(new Data(d.y, -d.x));
        }
        return normalize(rotated);
    }
    
    static List<Data> normalize(List<Data> adj){
        List<Data> norm = new ArrayList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(Data d: adj){
            minX = Math.min(minX, d.x);
            minY = Math.min(minY, d.y);
        }
        for(Data d: adj){
            norm.add(new Data(d.x - minX, d.y - minY));
        }
        Collections.sort(norm); //
        return norm;
    }
    
    static List<Data> extractSpaces(int x, int y, int[][] board, int target){
        List<Data> adj = new ArrayList<>();
        adj.add(new Data(x, y));
        Queue<Data> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Data(x, y));
        while(!q.isEmpty()){
            Data data = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)continue; //범위
                if(visited[nx][ny])continue; //방문
                if(board[nx][ny] != target)continue; //장애물
                adj.add(new Data(nx, ny));
                visited[nx][ny] = true;
                q.offer(new Data(nx, ny));
            }
        }
        return normalize(adj);
    }
    static class Data implements Comparable<Data>{
        int x, y;
        
        Data(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Data o){
            if(this.x == o.x)return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
    }
}