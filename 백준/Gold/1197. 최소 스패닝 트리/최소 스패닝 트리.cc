#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
struct A {
   int f, t, c;
   bool operator<(A &p){
      return c < p.c;// 오름차순
   }
};
A a[100001];

int p[10001];
int Find(int x){
    if(x == p[x])return x; // 부모 찾음
    else return p[x] = Find(p[x]); // 부모 못찾음
}
void Union(int x, int y) {
   x = p[x];
   y = p[y];
   p[y] = p[x];
}

int main() {
   ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

   int n, m;
   cin >> n >> m;

   for (int i = 1; i <= n; i++)p[i] = i; // make-set
		
	 // 연결
   for (int i = 0; i < m; i++) {
      cin >> a[i].f >> a[i].t >> a[i].c;
   }

   sort(a, a + m); // 정렬

   int ret = 0;
   for (int i = 0; i < m; i++){ // 간선들을...

      int t1 = Find(a[i].f), t2 = Find(a[i].t);

      if (t1 != t2){ // 다른그룹 이면 -> Union
         ret += a[i].c;
         Union(t1, t2);
      }
   }
   
   cout << ret;
}