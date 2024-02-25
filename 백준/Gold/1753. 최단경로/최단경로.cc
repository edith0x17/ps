#include <iostream>
#include <queue>
using namespace std;
const int INF = 987654321;
int n, m;
int d[20001];
struct A {
   int x, d; // 해당정점까지, 해당정점까지의 가중치 => x, d[x]

//    bool operator<(const A& p)const {
//       return d > p.d;
//    }
};
vector<A> v[20001];
// priority_queue<A> pq;

struct cmp{
    
    bool operator()(A o1, A o2){
        return o1.d > o2.d;
    }
};
priority_queue<A, vector<A>, cmp> pq;

void dijkstra(int start) {
   for (int i = 1; i <= n; i++)d[i] = INF; // INF

   d[start] = 0;
   
   pq.push({start, 0});
   while (!pq.empty()) {
      int x = pq.top().x;
      pq.pop();

      for (auto next: v[x]) { // next -> struct A...

         if (d[next.x] > d[x] + next.d) { // direct || bypass

            d[next.x] = d[x] + next.d;
            pq.push({next.x, d[next.x]});
         }
      }
   }
   
}
int main() {
   ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

   cin >> n >> m;

   int start;
   cin >> start;

   while (m--) {
      int x, y, z;
      cin >> x >> y >> z;

      v[x].push_back({y, z}); // 방향그래프
   }

   dijkstra(start);

   for (int i = 1; i <= n; i++) {

      if (d[i] == INF)cout << "INF\n";
      else cout << d[i] << '\n';
   }
}