/*
v.at(i) = Vector에서 i번 Index의 값을 가져온다   
v.insert(i, b) = i의 위치에 b값을 삽입한다
v.erase(i) = Vector에서 i번 Index의 값을 삭제한다
*/
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, mx = -987654321;
int a[14];
vector<int> v;

void go(int sum){
   
   if(v.size() == 2){
      mx = max(mx, sum);
      return;
   }

   for(int i = 1; i < v.size() - 1; i++){
      
      int select = v.at(i);

      sum += v.at(i - 1) * v.at(i + 1); // i - 1 select[i] i + 1 - PLUS
      v.erase(v.begin() + i);

      go(sum);

      v.insert(v.begin() + i, select);
      sum -= v.at(i - 1) * v.at(i + 1); // i - 1 select[i] i + 1 - SUBTRACT

   }
}

int main(){
   ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

   cin  >> n;
   for(int i = 0; i < n; i++){
      int num;
      cin >> num;
      v.push_back(num);
   }

   go(0);

   cout << mx << '\n';
   return 0;
}