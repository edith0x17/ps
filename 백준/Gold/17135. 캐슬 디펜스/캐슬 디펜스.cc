#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <algorithm>
using namespace std;
struct Data
{
   int x;
   int y;
   int d;
};
struct compare
{
   bool operator()(Data &d1, Data &d2)
   { // @@@
      if (d1.d == d2.d)
      {
         return d1.y > d2.y;
      }

      return d1.d > d2.d;
   }
};

int n, m, d, mx = -987654321;
int a[19][19], aOri[19][19];

void print()
{
   for (int i = 0; i < n; i++)
   {
      for (int j = 0; j < m; j++)
      {
         cout << a[i][j] << ' ';
      }
      cout << '\n';
   }
}
vector<pair<int, int>> enemy;

void init()
{
   for (int i = 0; i < n; i++)
   {
      for (int j = 0; j < m; j++)
      {
         a[i][j] = aOri[i][j];
      }
   }
}

void findEnemy()
{
   enemy.clear();

   for (int i = 0; i < n; i++)
   {
      for (int j = 0; j < m; j++)
      {
         if (a[i][j] == 1)
            enemy.push_back({i, j});
      }
   }
}
void goFoward()
{
   for (int i = n - 1; i >= 1; i--)
   { // 뒤 -> 앞
      for (int j = 0; j < m; j++)
      {
         a[i][j] = a[i - 1][j]; // 뒤 -> 앞
      }
   }

   for (int i = 0; i < n; i++)
   { // row == 0
      a[0][i] = 0;
   }
}

int findDistance(int sx, int sy, int ex, int ey)
{
   return abs(sx - ex) + abs(sy - ey);
}

void go(int aa, int bb, int cc)
{ // 궁수위치 -> a[n][i] a[n][j] a[n][k]

   int turn = n;
   int killCnt = 0;
   while (turn--)
   {
      findEnemy(); // <<-- <<--

      // cout << "turn : " << turn << '\n';                                                 // 턴 -> 행 기준
      
      // print();

      priority_queue<Data, vector<Data>, compare> A; // 궁수1
      priority_queue<Data, vector<Data>, compare> B; // 궁수2
      priority_queue<Data, vector<Data>, compare> C; // 궁수3

      for (pair<int, int> p : enemy)
      {
         int d1 = findDistance(n, aa, p.first, p.second);
         int d2 = findDistance(n, bb, p.first, p.second);
         int d3 = findDistance(n, cc, p.first, p.second);

         Data temp;
         temp.x = p.first;
         temp.y = p.second;

         temp.d = d1;
         if (d1 <= d)
            A.push(temp);

         temp.d = d2;
         if (d2 <= d)
            B.push(temp);

         temp.d = d3;
         if (d3 <= d)
            C.push(temp);
         
         // cout << "거리 " << d1 << ' ' << d2 << ' ' << d3 << '\n';
      }

      if (A.size() != 0)
      {
         if (a[A.top().x][A.top().y] == 1)
         {
            a[A.top().x][A.top().y] = 0;
            // cout << "A kill " << A.top().x << " : " << A.top().y << '\n';
            killCnt++;
         }
      }
      if (B.size() != 0)
      {
         if (a[B.top().x][B.top().y] == 1)
         {
            a[B.top().x][B.top().y] = 0;
            // cout << "B kill " << B.top().x << " : " << B.top().y << '\n';
            killCnt++;
         }
      }
      if (C.size() != 0)
      {
         if (a[C.top().x][C.top().y] == 1)
         {
            a[C.top().x][C.top().y] = 0;
            // cout << "C kill " << C.top().x << " : " << C.top().y << '\n';
            killCnt++;
         }
      }

      // cout << "적들 죽인 이후\n";
      // print();

      goFoward();

   }

   mx = max(mx, killCnt);
}
int main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);
   cout.tie(NULL);

   cin >> n >> m >> d;
   for (int i = 0; i < n; i++)
   {
      for (int j = 0; j < m; j++)
      {
         cin >> a[i][j];
         aOri[i][j] = a[i][j];

         if (a[i][j] == 1)
            enemy.push_back({i, j});
      }
   }

   for (int i = 0; i < m; i++)
   {
      for (int j = i + 1; j < m; j++)
      {
         for (int k = j + 1; k < m; k++)
         {
            init();
            
            // cout << "궁수 위치 " << i << " : " << j << " : " << k << '\n'; 
            go(i, j, k);
         }
      }
   }

   cout << mx << '\n';

   return 0;
}