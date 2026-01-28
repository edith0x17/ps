import java.io.*;
import java.util.*;

public class Main {
    static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Room {
        int baseLevel;
        ArrayList<Player> players = new ArrayList<>();

        public Room(int baseLevel) {
            this.baseLevel = baseLevel;
        }
    }

    static int p, m;
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        while (p-- > 0) {
            int l;
            String n;
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();
            /*boolean ok = false;
            for (...) {
                if (조건) {
                    처리;
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                새로 만든다;
            }*/
            boolean entered = false;
            for (Room room : rooms) {
                if (room.players.size() < m && (room.baseLevel - 10 <= l && l <= room.baseLevel + 10)) {
                    room.players.add(new Player(l, n));
                    entered = true;
                    break;
                }
            }
            if (!entered) {
                Room room = new Room(l);
                room.players.add(new Player(l, n));
                rooms.add(room);
            }
        }
        for (Room room : rooms) {
            Collections.sort(room.players);//sort
            if (room.players.size() < m) {
                System.out.println("Waiting!");
            } else {
                System.out.println("Started!");
            }
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }
}