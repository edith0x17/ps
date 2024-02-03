#include <iostream>
#include <vector>
using namespace std;

/*
* [x][value]
* [y][value]
* [sum][value]
*/

int a[9][9];
bool check1[104][104], check2[104][104], check3[104][104] ; // check1, 2 -> 행 열, check3 -> ㅁ * 9
vector<pair<int, int>> vv; // 0인 지점 담기
bool flag = false;

void print(){
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            cout << a[i][j];
        }
        cout << '\n';
    }
}
void solve(int idx){ // idx == depth

    if(idx == vv.size()){ // vv 다 소비
        flag = true;
        print();
        return;
    }

    int x = vv[idx].first; int y = vv[idx].second;
    for(int i = 1; i <= 9; i++){
        if(check1[x][i])continue; // 행 체크

        if(check2[y][i])continue; // 열 체크

        int sum = (x / 3) * 3 + (y / 3);
        if(check3[sum][i])continue; // ㅁ 체크

        a[x][y] = i;
        check1[x][i] = true;
        check2[y][i] = true;
        check3[sum][i] = true;

        solve(idx + 1);
        if(flag)return; // 사전순 출력

        check1[x][i] = false;
        check2[y][i] = false;
        check3[sum][i] = false;
    }

    

}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            scanf("%1d", &a[i][j]);

            int value = a[i][j];

            if(a[i][j] == 0){ // 0인 지점 담기
                vv.push_back({i, j}); 
            }else{ // 0이 아닌 지점 방문 표시
                check1[i][value] = true;
                check2[j][value] = true;

                int sum = (i / 3) * 3 + (j / 3);
                check3[sum][value] = true;
            }
        }
    }

    solve(0);

    return 0;
}
