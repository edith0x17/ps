#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

const int dx[] = { -1, 0, 1, 0 };  // 상, 우, 하, 좌 이동
const int dy[] = { 0, 1, 0, -1 };
int dir = 1;  // 처음에는 오른쪽 방향
int n, k, l;
vector<pair<int, int>> snake;
int a[104][104];  // 사과 위치 저장
vector<pair<int, char>> turn;
map<pair<int, int>, int> mp;  // 뱀의 몸 위치 저장
int ret = 0;

int go() {
    for (;;) {
        int x = snake[0].first;
        int y = snake[0].second;

        /*
        // 뱀의 머리가 벽에 부딪히는지 확인
        if (x < 0 || x >= n || y < 0 || y >= n) {
            break;
        }
        */

        // 방향 변환 처리
        for (auto at : turn) {
            if (ret == at.first) {
                if (at.second == 'L') {
                    dir = (dir + 3) % 4;  // 왼쪽으로 회전
                }
                else {
                    dir = (dir + 1) % 4;  // 오른쪽으로 회전
                }
                break;
            }
        }

        // 뱀의 새로운 위치 계산
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 범위를 벗어났는지 확인
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            return ret + 1;  // 벽에 부딪힌 경우 종료
        }

        // 뱀의 몸에 부딪히는지 확인
        if (mp.find({ nx, ny }) != mp.end()) {
            return ret + 1;  // 몸에 부딪힌 경우 종료
        }

        // 새로운 위치로 뱀 이동
        snake.insert(snake.begin(), { nx, ny });  // 머리 추가 @@@
        mp[{nx, ny}] = 1;  // 새로운 머리 위치 저장

        // 사과가 있으면 꼬리를 제거하지 않음
        if (a[nx][ny] == 1) {
            a[nx][ny] = 0;  // 사과 먹음
        }
        else {
            // 꼬리 제거
            pair<int, int> tail = snake.back();
            mp.erase(tail);  // 꼬리 위치 제거
            snake.pop_back();  // 꼬리 제거
        }
        ret++;  // 시간 경과
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> k;
    for (int i = 0; i < k; i++) {
        int x, y;
        cin >> x >> y;
        a[x - 1][y - 1] = 1;  // 사과 위치 저장
    }
    cin >> l;
    for (int i = 0; i < l; i++) {
        int t; char c;
        cin >> t >> c;
        turn.push_back({ t, c });  // 방향 전환 정보 저장
    }

    snake.push_back({ 0, 0 });  // 뱀의 초기 위치
    mp[{0, 0}] = 1;  // 뱀의 초기 위치 저장

    cout << go() << "\n";  // 게임 시작
    return 0;
}