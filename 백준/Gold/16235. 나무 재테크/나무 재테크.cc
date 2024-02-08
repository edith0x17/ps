#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int n, m, k;
int a[14][14];
struct POS{
    int y;
    int x;
    int age;
};
vector<POS> pos;

struct Tree{
    vector<int> live;// {나이}
    vector<int> dead;// {나이}
    int sum;// 양분
};
Tree map[14][14];
// 봄
void spring(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){

            int k;
            for(k = 0; k < map[i][j].live.size(); k++){
                if(map[i][j].sum - map[i][j].live[k] < 0){
                    break;
                }else{
                    map[i][j].sum -= map[i][j].live[k];
                    map[i][j].live[k] += 1;
                }
            }

            for(int temp = map[i][j].live.size() - 1; k <= temp; temp--){
                map[i][j].dead.push_back(map[i][j].live[temp]);// 죽음
                map[i][j].live.pop_back();
            }

        }
    }
    // cout << "spring\n";
}
// 여름
void summer(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            
            for(int k = map[i][j].dead.size() - 1; 0 <= k; k--){
                map[i][j].sum += map[i][j].dead[k] / 2;
                map[i][j].dead.pop_back();
            }
        }
    }
    // cout << "summer\n";
}
// 가을
void fall(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){

            for(int k = 0; k < map[i][j].live.size(); k++){
                if(map[i][j].live[k] % 5 == 0){
                    for(int dir = 0; dir < 8; dir++){
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];

                        if(ny < 0 || ny >= n || nx < 0 || nx >= n)continue;

                        map[ny][nx].live.push_back(1);
                        // sort(map[ny][nx].live.begin(), map[ny][nx].live.end());


                    }
                }
            }

        }
    }
    // cout << "fall\n";
}
// 겨울
void winter(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            map[i][j].sum += a[i][j];
        }
    }
    // cout << "winter\n";
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m >> k;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }

    for(int i = 0; i < m; i++){
        int y, x, z;
        cin >> y >> x >> z;
        y--; x--;
        POS p;
        p.y = y; p.x = x; p.age =z;
        pos.push_back(p);
    }

    for(POS p: pos){
        map[p.y][p.x].live.push_back(p.age);
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            map[i][j].sum = 5;
            sort(map[i][j].live.begin(), map[i][j].live.end());
        }
    }

    for(int i = 0; i < k; i++){
        spring(); 
        summer(); 
        fall(); 
        for(int aa = 0; aa < n; aa++){
            for(int bb = 0; bb < n; bb++){
                if(map[aa][bb].live.size())sort(map[aa][bb].live.begin(), map[aa][bb].live.end());
            }
        }
        winter();
    }

    // cout << "check point\n";

    int ret = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(map[i][j].live.size())ret += map[i][j].live.size();
        }
    }
    cout << ret;
    return 0;
}
