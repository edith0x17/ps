#include <bits/stdc++.h>
using namespace std;
int a[14][14];
vector<pair<int, int>> vv;

bool check1[104][104], check2[104][104], check3[104][104];

bool flag;
void print(){
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            cout << a[i][j];
        }
        cout << '\n';
    }
}

void go(int idx){ // 
    if(idx == vv.size()){
        flag = true;
        print();
        return;
    }

    int x = vv[idx].first; 
    int y = vv[idx].second;
    for(int i = 1; i <= 9; i++){
        if(check1[x][i])continue;
        if(check2[y][i])continue;
        int sum = (x/ 3)* 3 + (y/ 3);
        if(check3[sum][i])continue;

        a[x][y] = i;
        check1[x][i] = true;
        check2[y][i] = true;
        check3[sum][i] = true;

        go(idx + 1);
        if(flag)return;

        check1[x][i] = false;
        check2[y][i] = false;
        check3[sum][i] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    for(int i = 0; i < 9; i++){
        string s;
        cin >> s;
        for(int j = 0; j < 9; j++){
            a[i][j] = s[j] - '0';
            int value = a[i][j];

            if(value == 0)vv.push_back({i, j});
            else{
                check1[i][value] = true;// 행 ex) 0, 1, 2, 3
                check2[j][value] = true;// 열 

                int sum = (i/ 3) * 3 + (j/ 3); //ㅁ
                check3[sum][value] = true;
            }
        }
    }
    
    go(0);

    return 0;
}