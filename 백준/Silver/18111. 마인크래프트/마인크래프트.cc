#include <bits/stdc++.h>
using namespace std;
int n, m, b;
int a[504][504];
int retHeight, retTime = INT_MAX;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> n >> m >> b;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }

    for(int k = 0; k <= 256; k++){
        // 설정한 높이 -> k
        int remove = 0; // 지울것
        int build = 0; // 채울것
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int height = a[i][j] - k;

			    if (height > 0) remove += height;
				else if (height < 0) build -= height;
            }
        }

        if(remove + b >= build){
            int t = (2 * remove) + (1 * build);

            if(retTime >= t){
                retHeight = k;
                retTime = t;
            }
        }
    }

    cout << retTime << " " << retHeight << "\n";
    
    return 0;
}