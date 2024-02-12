#include <iostream>
#include <cmath>
using namespace std;
int n, r, c;
int ret, cnt;
void go(int s, int x, int y){
    // cout << "cnt : " << cnt << '\n';
    if(x == r && y == c){ // r과 c
        ret = cnt;
        return;
    }

    else if (r >= x && c >= y && r < x + s && c < y + s ){ // r과 c가 4분면에 있을때

        int k = s / 2;

        go(k, x, y);

        go(k, x, y + k);

        go(k, x + k, y);

        go(k, x + k, y + k);
    }else{ // 정사각형 넓이
        cnt += s * s; // 각 사각형의 면적이 1인 경우(사각형의 한 변의 길이인 s가 1인 경우) cnt + 1
    }
}
int main(){
    cin >> n >> r >> c;

    go(pow(2, n), 0, 0);

    cout << ret << '\n';

    return 0;
}
