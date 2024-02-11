#include <iostream>
using namespace std;
int n, cntW, cntB;
int a[1024][1024];

bool check(int s, int x, int y){

    int prev = a[x][y];

     for(int i = x; i < x + s; i++){

        for(int j = y; j < y + s; j++){

            if(prev != a[i][j])return false;
        }
    }
    return true;
}

void go(int s, int x, int y){

    if(check(s, x, y)){
        if(a[x][y] == 1) cntB++;
        else cntW++;

        return;
    }

    int half_s = s / 2; 
    go(half_s, x, y);
    go(half_s, x, y + half_s);
    go(half_s, x + half_s, y);
    go(half_s, x + half_s, y + half_s);
    

}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    for(int i = 0; i < n; i++){

        for(int j = 0; j < n; j++){

            cin >> a[i][j];
        }
    }

    go(n, 0, 0);

    cout << cntW << '\n' << cntB;

    return 0;
}