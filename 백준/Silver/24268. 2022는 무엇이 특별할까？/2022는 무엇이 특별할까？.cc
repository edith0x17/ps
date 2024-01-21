#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;
int radix;
vector<int> v;
unordered_map<int, int> mp;

void FastIO(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

// void check(int ret){
//     if(~ret){
//         cout << "값이 있음\n";
//     }else{
//         cout << "값이 없음\n";
//     }
// }

// void change(){
//     int radix, decimal;
//     vector<int> v;

//     cout << "변환하고 싶은 진법을 입력하세요: ";
//     cin >> radix;

//     if(radix < 2 || radix > 16){
//         cout << "변환할 수 없는 진법입니다\n";
//     }else{
//         cout << "변환할 수를 입력하세요: ";
//         cin >> decimal;
//         while(decimal >= radix){ 
//             v.push_back(decimal % radix);
//             decimal = decimal / radix;
//         }
//         v.push_back(decimal); // 털어내기 -> 

//         reverse(v.begin(), v.end());

//         cout << radix << "진법으로 변환된 수: ";
//         for(int i: v){
//             cout << i << " ";
//         }
//     }
// }

bool check(){
    bool flag = false;
    for(int i = 0; i < radix; i++){
        if(mp[i] == 1){
            flag = true;
        }else{
            flag = false;
            return flag;
        }
    }

    return flag;
}
int Solve(){
    int n, d, ret;
    cin >> n >> d;

    vector<int> v;
    
    for(int i = 0; i < d; i++){
        v.push_back(i);
    }
    
    do{
        if(v[0] == 0) continue; // 0123...(X)

        ret = 0; // 초기화

       for(int i = 0 ; i < v.size() ; i++){
            ret += v[v.size() - i - 1] * pow(d, i); // (radix ** n) + (radix ** n - 1) + ... + (radix ** 0)
        }


        if(ret > n){
            return ret;
        }
        
    }while(next_permutation(v.begin(), v.end()));

    return -1;
}

int main(){
    FastIO();
    cout << Solve();
    return 0;
}