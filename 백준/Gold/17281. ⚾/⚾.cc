#include <bits/stdc++.h>
using namespace std;
int ret = -987654321;

int n, a[54][13];
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n; 
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < 9; j++){
            cin >> a[i][j];
        }
    }
    // 1 2 3 4 5 6 7 8 9 hitter num
    // 0 1 2 3 4 5 6 7 8 idx
    int np[] = {1, 2, 3, 4, 5, 6, 7, 8};
    do{
        deque<int> hitter; 
        for(int i = 0; i < 3; i++)hitter.push_back(np[i]); // 1 ~ 3
        hitter.push_back(0); // 4
        for(int i = 3; i < 8; i++) hitter.push_back(np[i]); // 5 ~ 9

        int ining = 0, score = 0;
        while(ining < n){
            int out = 0;

            queue<int> base;
            for(int i = 0; i < 3; i++)base.push(0);

            while(out < 3){
                int now = hitter.front();
                hitter.pop_front();

                hitter.push_back(now);

                if(a[ining][now] == 0)out++;
                else{
                    if(base.front() == 1)score++;

                    // 1루 진루
                    base.push(1);
                    base.pop();

                    // 나머지 진루
                    for(int i = 0; i < a[ining][now] - 1; i++){
                        if(base.front() == 1)score++;

                        base.push(0);
                        base.pop();
                    }    
                }
            }
            ining++;
        }
        ret = max(ret, score);
    }while(next_permutation(np, np + 8));
    
    cout << ret << "\n";
    return 0;
}
